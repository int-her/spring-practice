package com.huzz.practice.service

import com.huzz.practice.dao.PostDao
import com.huzz.practice.entity.PostEntity
import com.huzz.practice.enum.PostTypeEnum
import org.slf4j.LoggerFactory

class PostService(
        private val postDao: PostDao
) {

  companion object {
    private val logger = LoggerFactory.getLogger(PostService::class.java)
  }

  fun getAllPostList() : List<PostEntity>? {
//    logger.info("Call {}.", "getAllPostList")
    return postDao.selectAllPostList()
  }

  fun getPostByUid(uid: Int) = postDao.selectPostByUid2(uid)

  fun insertPost(title: String, subtitle: String?, content: String?) {
    postDao.insertPost2(title, subtitle, content, PostTypeEnum.TWO)
  }

  fun updatePostByEntity(entity: PostEntity) {
    postDao.updatePostByUidAndEntity2(entity)
  }

  fun deletePostByUid(uid: Int) {
    postDao.deletePostByUid2(uid)
  }
}
