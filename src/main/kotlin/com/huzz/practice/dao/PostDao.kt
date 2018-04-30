package com.huzz.practice.dao

import com.huzz.practice.entity.PostEntity
import com.huzz.practice.enum.PostTypeEnum
import com.huzz.practice.mapper.PostMapper

class PostDao(
        private val postMapper: PostMapper
) : PostMapper {
  companion object {
    // log
  }

  override fun selectPostByUid(uid: Int): PostEntity? {
    return postMapper.selectPostByUid(uid)
  }

  override fun selectPostByUid2(uid: Int): PostEntity? {
    return postMapper.selectPostByUid2(uid)
  }

  override fun insertPost(title: String, subtitle: String?, content: String?) {
    return postMapper.insertPost(title, subtitle, content)
  }

  override fun selectAllPostList(): List<PostEntity>? {
    return postMapper.selectAllPostList()
  }

  override fun insertPost2(title: String, subtitle: String?, content: String?, type: PostTypeEnum) {
    return postMapper.insertPost2(title, subtitle, content, type)
  }

  override fun updatePost(entity: PostEntity) {
    return postMapper.updatePost(entity)
  }

//  override fun updatePostByUidAndEntity2(uid: Int, title: String?, subtitle: String?, content: String?) {
  override fun updatePostByUidAndEntity2(entity: PostEntity) {
    return postMapper.updatePostByUidAndEntity2(entity)
  }

  override fun deletePost(uid: Int) {
    return postMapper.deletePost(uid)
  }

  override fun deletePostByUid2(uid: Int) {
    return postMapper.deletePostByUid2(uid)
  }
}
