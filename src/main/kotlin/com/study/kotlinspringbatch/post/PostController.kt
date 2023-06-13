package com.study.kotlinspringbatch.post

import com.study.kotlinspringbatch.post.dto.IdResponse
import com.study.kotlinspringbatch.post.dto.PostRequest
import com.study.kotlinspringbatch.post.dto.PostResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
    fun savePost(@Valid @RequestBody postRequest: PostRequest): ResponseEntity<IdResponse<Long>> =
            ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(postRequest))

    @GetMapping
    fun findAll(): ResponseEntity<List<PostResponse>> =
            ResponseEntity.ok(postService.findAll())
}
