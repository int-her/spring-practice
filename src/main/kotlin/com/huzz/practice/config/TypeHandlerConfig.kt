package com.huzz.practice.config

import com.huzz.practice.enum.PostTypeEnum
import org.apache.ibatis.type.TypeHandler

object TypeHandlerConfig {
  @JvmStatic
  fun getTypeHandlerList(): Array<TypeHandler<out Any>> {
    return arrayOf(
            PostTypeEnum.TypeHandler()
    )
  }
}
