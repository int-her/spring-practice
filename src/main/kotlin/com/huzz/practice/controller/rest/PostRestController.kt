package com.huzz.practice.controller.rest

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.huzz.practice.dao.PostDao
import com.huzz.practice.entity.PostEntity
import com.huzz.practice.enum.PostTypeEnum
import com.huzz.practice.service.PostService
import org.springframework.web.bind.annotation.*

@RestController
open class PostRestController(
        private val postService: PostService
) {
  companion object {
    const val URL_POST_GET = "/api/post/get"
    const val URL_POST_ALL = "/api/post/all"
    const val URL_POST_POST = "/api/post/post"
    const val URL_POST_UPDATE = "/api/post/update"
    const val URL_POST_DELETE = "/api/post/delete"
    const val URL_POST_TEST = "/api/post"
  }

  @RequestMapping(value = [URL_POST_GET, URL_POST_TEST], method = [RequestMethod.GET])
  open fun getPost(@RequestParam uid: Int): PostEntity? {
    return postService.getPostByUid(uid)
  }

  @RequestMapping(value = [URL_POST_ALL], method = [RequestMethod.GET])
  open fun getPostAll(): List<PostEntity>? {
    return postService.getAllPostList()
  }

  @RequestMapping(value = [URL_POST_POST, URL_POST_TEST], method = [RequestMethod.POST])
  open fun postPost(
          @RequestBody request: PostPostRequest
  ): String {
    postService.insertPost(request.title, request.subtitle, request.content)
    return "success"
  }

  data class PostPostRequest @JsonCreator constructor(
          @param:JsonProperty("title") val title: String,
          @param:JsonProperty("subtitle") val subtitle: String?,
          @param:JsonProperty("content") val content: String?
  )

  @RequestMapping(value = [URL_POST_UPDATE], method = [RequestMethod.POST])
  open fun updatePost(
          @RequestBody request: UpdatePostRequest
  ): String {
    val post = if (postService.getPostByUid(request.uid) != null) postService.getPostByUid(request.uid)!!
      else throw NullPointerException("Expression 'postDao.selectPostByUid2(request.uid)' must not be null")
    post.title = request.title
    post.subtitle = request.subtitle
    post.content = request.content
//    postDao.updatePostByUidAndEntity2(request.uid, request.title, request.subtitle, request.content)
    postService.updatePostByEntity(post)
    return "success"
  }

  data class UpdatePostRequest @JsonCreator constructor(
          @param:JsonProperty("uid") val uid: Int,
          @param:JsonProperty("title") val title: String?,
          @param:JsonProperty("subtitle") val subtitle: String?,
          @param:JsonProperty("content") val content: String?
  )

  @RequestMapping(value = [URL_POST_DELETE], method = [RequestMethod.POST])
  open fun deletePost(
          @RequestBody request: DeletePostRequest
  ): String {
    postService.deletePostByUid(request.uid)
    return "success"
  }

  data class DeletePostRequest @JsonCreator constructor(
          @param:JsonProperty("uid") val uid: Int
  )
}
