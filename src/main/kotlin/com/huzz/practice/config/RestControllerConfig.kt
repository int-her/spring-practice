package com.huzz.practice.config

import com.huzz.practice.controller.rest.MainRestController
import com.huzz.practice.controller.rest.PostRestController
import com.huzz.practice.dao.PostDao
import com.huzz.practice.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
        ServiceConfig::class
)
//@ComponentScan(basePackages = ["com.practice.huzz"])
open class RestControllerConfig(
        @Autowired private val postService: PostService
) {

  @Bean
  open fun mainRestController(): MainRestController = MainRestController()

  @Bean
  open fun postRestController(): PostRestController =
          PostRestController(
                  postService = postService
          )
}
