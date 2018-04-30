package com.huzz.practice.controller.view

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
open class MainViewController {

  companion object {
    const val URL_MAIN = "/"
  }

  @RequestMapping(value = [URL_MAIN], method = [RequestMethod.GET])
  open fun main(model: Model): String {
    return "index"
  }
}
