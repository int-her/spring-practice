package com.huzz.practice.config

import com.huzz.practice.controller.view.MainViewController
import com.huzz.practice.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
        ServiceConfig::class
)
//@ComponentScan(basePackages = ["com.practice.huzz"])
open class ViewControllerConfig(
        @Autowired private val postService: PostService
) {

  @Bean
  open fun mainViewController(): MainViewController = MainViewController()
}
