package com.study.kotlinspringbatch.post

import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post,Long>
