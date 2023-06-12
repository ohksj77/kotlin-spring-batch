package com.study.kotlinspringbatch.post

import com.study.kotlinspringbatch.post.dto.IdResponse
import com.study.kotlinspringbatch.post.dto.PostRequest
import com.study.kotlinspringbatch.post.dto.PostResponse
import org.springframework.stereotype.Service

@Service
class PostService(
        private val postRepository: PostRepository,
        private val postMapper: PostMapper
) {
    fun savePost(postRequest: PostRequest): IdResponse<Long> {
        val post: Post = postMapper.toEntity(postRequest)
        return IdResponse(postRepository.save(post).id!!)
    }

    fun findAll(): List<PostResponse> {
        val postList: List<Post> = postRepository.findAll()
        return postMapper.toResponseList(postList)
    }
}
