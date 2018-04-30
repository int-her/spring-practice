package com.huzz.practice.tx

import com.huzz.practice.config.MybatisConfig
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.TransactionException
import org.springframework.transaction.support.DefaultTransactionDefinition

class Transaction(
        private val TxManager: DataSourceTransactionManager
) {
  companion object {
//    log
  }

  fun <T> run(block: () -> T): T {
    if (MybatisConfig.TxStatus.get() != null) {
      throw Exception()
    }

    val transactionStatus = TxManager.getTransaction(DefaultTransactionDefinition())
    MybatisConfig.TxStatus.set(transactionStatus)

    try {
      val response = block()

      TxManager.commit(transactionStatus)

      return response
    } catch (e: Exception) {
      try {
        TxManager.rollback(transactionStatus)
      } catch (te: TransactionException) {

      }
      throw e
    } finally {
      MybatisConfig.TxStatus.remove()
    }
  }

}
