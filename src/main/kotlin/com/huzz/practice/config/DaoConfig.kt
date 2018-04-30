package com.huzz.practice.config

import com.huzz.practice.dao.PostDao
import com.huzz.practice.mapper.PostMapper
import org.mybatis.spring.SqlSessionTemplate
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
        MybatisConfig::class
)
open class DaoConfig (
        @Qualifier(value = "sqlSessionTemplate") private val sqlSessionTemplate: SqlSessionTemplate
){
  @Bean
  open fun postDao(): PostDao =
          PostDao(
                  postMapper = sqlSessionTemplate.getMapper(PostMapper::class.java)
          )
}
