package com.study.kotlinspringbatch.post.dto

import javax.validation.constraints.NotBlank

data class PostRequest(
        @NotBlank
        val title: String,
        @NotBlank
        val content: String
)
