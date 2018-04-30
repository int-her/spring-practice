package com.huzz.practice.mapper

import com.huzz.practice.entity.PostEntity
import com.huzz.practice.enum.PostTypeEnum
import org.apache.ibatis.annotations.*

// Mapper는 interface로 구현되어야 한다.
interface PostMapper {

  // 어노테이션을 통한 쿼리 정의
  @Select("SELECT * FROM post WHERE uid = #{uid}")
  fun selectPostByUid(@Param("uid") uid: Int): PostEntity?

  // resources/{package.name}/PostMapper.xml 을 통한 쿼리 정의
  fun selectPostByUid2(@Param("uid") uid: Int): PostEntity?

  fun selectAllPostList(): List<PostEntity>?

  @Insert("INSERT INTO post" +
          "(title, subtitle, content, type, regist_datetime, update_datetime)" +
          "VALUES" +
          "(#{title}, #{subtitle}, #{content}, 2, NOW(), NOW())")
  fun insertPost(
          @Param("title") title: String,
          @Param("subtitle") subtitle: String?,
          @Param("content") content: String?
  )

  fun insertPost2(
          @Param("title") title: String,
          @Param("subtitle") subtitle: String?,
          @Param("content") content: String?,
          @Param("type") type: PostTypeEnum
  )

  @Update("UPDATE post" +
          "SET" +
          "title = CASE WHEN #{entity.title} IS NULL THEN title ELSE #{entity.title}," +
          "subtitle = CASE WHEN #{entity.subtitle} IS NULL THEN title ELSE #{entity.subtitle}," +
          "content = CASE WHEN #{entity.content} IS NULL THEN title ELSE #{entity.content}," +
          "type = CASE WHEN #{entity." +
          "update_datetime = NOW()" +
          "WHERE uid = #{uid}")
  fun updatePost(@Param("entity") entity: PostEntity)

  fun updatePostByUidAndEntity2(@Param("entity") entity: PostEntity)
//  fun updatePostByUidAndEntity2(
//          @Param("uid") uid: Int,
//          @Param("title") title: String?,
//          @Param("subtitle") subtitle: String?,
//          @Param("content") content: String?
//  )

  @Delete("DELETE FROM post WHERE uid = #{uid}")
  fun deletePost(@Param("uid") uid: Int)

  fun deletePostByUid2(@Param("uid") uid: Int)
}
