package com.huzz.practice.enum

import org.apache.ibatis.type.JdbcType
import org.apache.ibatis.type.MappedTypes
import java.sql.CallableStatement
import java.sql.PreparedStatement
import java.sql.ResultSet

enum class PostTypeEnum(val type: Int) {
  ZERO(0),
  ONE(1),
  TWO(2),
  THREE(3);

  companion object {
    fun from(type: Int): PostTypeEnum = PostTypeEnum.values().first { it.type == type }
  }

  @MappedTypes(PostTypeEnum::class)
  class TypeHandler : org.apache.ibatis.type.TypeHandler<PostTypeEnum> {
    override fun setParameter(ps: PreparedStatement?, i: Int, parameter: PostTypeEnum?, jdbcType: JdbcType?) {
      ps!!.setInt(i, parameter!!.type)
    }

    override fun getResult(rs: ResultSet?, columnName: String?): PostTypeEnum {
      return from(rs!!.getInt(columnName))
    }

    override fun getResult(rs: ResultSet?, columnIndex: Int): PostTypeEnum {
      return from(rs!!.getInt(columnIndex))
    }

    override fun getResult(cs: CallableStatement?, columnIndex: Int): PostTypeEnum {
      return from(cs!!.getInt(columnIndex))
    }
  }
}
