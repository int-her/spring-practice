package com.huzz.practice.config

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class LoggerAspect {
  private val logger = LoggerFactory.getLogger(LoggerAspect::class.java)

  @Around("execution(* com.huzz.practice.controller..*.*(..))")
  fun aroundControllers(joinPoint: ProceedingJoinPoint): Any? {
    val type = joinPoint.signature.declaringTypeName

    val name = when {
      type.contains("Controller") ->  "Controller : "
      type.contains("Service") ->     "Service    : "
      type.contains("DAO") ->         "DAO        : "
      else -> {
        "ETC        : "
      }
    }

    try {
      logger.info("{}{}.{}()", name, type, joinPoint.signature.name)
      logger.error("?!?!?!?!?!?!?!?!?!?!")
      return joinPoint.proceed()
    } catch(e: Exception) {
      logger.error(e.message)
      throw e
    }
  }
}
