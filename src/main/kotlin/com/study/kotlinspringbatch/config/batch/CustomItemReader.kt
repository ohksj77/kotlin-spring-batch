package com.study.kotlinspringbatch.config.batch

import com.study.kotlinspringbatch.post.Post
import com.study.kotlinspringbatch.post.PostRepository
import org.springframework.batch.item.ItemReader
import org.springframework.context.annotation.Configuration
import javax.annotation.PostConstruct

@Configuration
class CustomItemReader(
        private var postRepository: PostRepository
): ItemReader<Post?> {
    private lateinit var list: MutableList<Post>
    private var nextIndex: Int = 0

    @PostConstruct
    fun init() {
        postRepository.save(Post("Kotlin Spring", "Hello Batch"))
        list = postRepository.findAll()
    }

    override fun read(): Post? = if (nextIndex < list.size) list[nextIndex++] else null
}
