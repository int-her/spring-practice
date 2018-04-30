package com.huzz.practice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
open class DataSourceConfig {

  @Bean(name = ["dataSource"])
  open fun dataSource(): DataSource {
    val dataSource = DriverManagerDataSource()
//    Class.forName("com.mysql.jdbc.Driver")
    dataSource.setDriverClassName("com.mysql.jdbc.Driver")
    dataSource.url = "jdbc:mysql://datasource.url"
    dataSource.username = "admin"
    dataSource.password = "12345678"
    return dataSource
  }
}
