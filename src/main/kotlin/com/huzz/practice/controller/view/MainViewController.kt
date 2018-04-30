package com.huzz.practice.controller.view

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
open class MainViewController {

  companion object {
    const val URL_INDEX = "/index"
  }

  @RequestMapping(value = [URL_INDEX], method = [RequestMethod.GET])
  open fun index(model: Model): String {
    model.addAttribute("amount", 76000000)
    return "index"
  }
}
