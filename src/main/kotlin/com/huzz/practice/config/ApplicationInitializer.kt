package com.huzz.practice.config

import org.springframework.web.WebApplicationInitializer
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext
import javax.servlet.ServletContext
import org.springframework.web.servlet.DispatcherServlet
import org.springframework.web.context.ContextLoaderListener
import org.springframework.web.servlet.view.InternalResourceViewResolver

class ApplicationInitializer : WebApplicationInitializer {
  override fun onStartup(container: ServletContext?) {
    val context = AnnotationConfigWebApplicationContext()
    context.register(WebMvcConfig::class.java)
    context.register(ViewControllerConfig::class.java)
    context.register(RestControllerConfig::class.java)
    context.register(ViewControllerConfig::class.java)
    container!!.addListener(ContextLoaderListener(context))

    val dispatcher = container.addServlet("dispatcher", DispatcherServlet(context))

    dispatcher.setLoadOnStartup(1)
    dispatcher.addMapping("/")
  }
}
