package com.huzz.practice.entity

import java.time.LocalDateTime
import com.huzz.practice.enum.PostTypeEnum

/*
  Entity에서 정의한 column 순서와 SELECT 쿼리를 통해 받아오는 결과의 column 순서가 동일해야 한다.
 */
data class PostEntity(
        var uid: Int? = null,
        var title: String? = null,
        var subtitle: String? = null,
        var content: String? = null,
        var type: PostTypeEnum? = null,
        var registDatetime: LocalDateTime? = null,
        var updateDatetime: LocalDateTime? = null
)
