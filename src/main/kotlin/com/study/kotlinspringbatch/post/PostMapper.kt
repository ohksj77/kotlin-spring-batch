package com.study.kotlinspringbatch.post

import com.study.kotlinspringbatch.post.dto.PostRequest
import com.study.kotlinspringbatch.post.dto.PostResponse
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface PostMapper {
    fun toEntity(postRequest: PostRequest) : Post
    fun toResponse(post: Post): PostResponse
    fun toResponseList(postList: List<Post>) : List<PostResponse> = postList.map {toResponse(it)}
}
