package com.huzz.practice.config

import com.huzz.practice.mapper.PostMapper
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.transaction.TransactionStatus
import javax.sql.DataSource

@Configuration
@Import(
        DataSourceConfig::class
)
@MapperScan(basePackages = ["com.practice.huzz.mapper"])
open class MybatisConfig {
  companion object {
    val TxStatus = ThreadLocal<TransactionStatus>()
  }

  @Bean(name = ["sqlSessionFactory"])
  open fun sqlSessionFactoryBean(@Qualifier("dataSource") dataSource: DataSource): SqlSessionFactory {
    val sqlSessionFactoryBean = SqlSessionFactoryBean()
    sqlSessionFactoryBean.setDataSource(dataSource)

    // TypeHandler 추가
    sqlSessionFactoryBean.setTypeHandlers(TypeHandlerConfig.getTypeHandlerList())

    val sqlSessionFactory = sqlSessionFactoryBean.`object`
    val configuration = sqlSessionFactory.configuration
    configuration.addMapper(PostMapper::class.java)

    return sqlSessionFactory
  }

  @Bean(name = ["sqlSessionTemplate"])
  open fun sqlSessionTemplate(@Qualifier("sqlSessionFactory") sqlSessionFactory: SqlSessionFactory): SqlSessionTemplate {
    return SqlSessionTemplate(sqlSessionFactory)
  }
}
