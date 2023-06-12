package com.study.kotlinspringbatch.post

import com.study.kotlinspringbatch.post.dto.IdResponse
import com.study.kotlinspringbatch.post.dto.PostRequest
import com.study.kotlinspringbatch.post.dto.PostResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/post")
class PostController(
        private val postService: PostService
) {
    @PostMapping
    fun savePost(@Valid @RequestBody postRequest: PostRequest): IdResponse<Long> = postService.savePost(postRequest)

    @GetMapping
    fun findAll(): List<PostResponse> = postService.findAll()
}
