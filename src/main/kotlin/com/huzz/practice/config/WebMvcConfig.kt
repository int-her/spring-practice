package com.huzz.practice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.servlet.view.InternalResourceViewResolver

@Configuration
@EnableWebMvc
open class WebMvcConfig : WebMvcConfigurerAdapter() {

  @Bean
  open fun internalResourceViewResolver(): InternalResourceViewResolver {
    val irvr = InternalResourceViewResolver()
    irvr.setSuffix(".jsp")
    irvr.setPrefix("/WEB-INF/jsp/")
    return irvr
  }
}
