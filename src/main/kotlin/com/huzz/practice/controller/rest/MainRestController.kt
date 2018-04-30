package com.huzz.practice.controller.rest

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
open class MainRestController {
  companion object {
    const val URL_HI = "/hi"
    const val URL_HELLO = "/hello"
  }

  @RequestMapping(value = [URL_HI], method = [RequestMethod.GET])
  open fun hi(): String {
    return "hi"
  }

  @RequestMapping(value = [URL_HELLO], method = [RequestMethod.GET])
  open fun hello(@RequestParam name: String): String {
    return "hello $name!"
  }
}
