package com.huzz.practice.config

import com.huzz.practice.dao.PostDao
import com.huzz.practice.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
        DaoConfig::class
)
open class ServiceConfig(
        @Autowired private val postDao: PostDao
) {
  @Bean
  open fun postService() = PostService(
          postDao = postDao
  )
}
