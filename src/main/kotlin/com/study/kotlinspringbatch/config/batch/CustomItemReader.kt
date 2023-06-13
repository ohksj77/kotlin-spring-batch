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
    private val title = "Kotlin Spring"
    private val content = "Hello Batch"

    @PostConstruct
    fun init() {
        postRepository.save(Post(title, content))
        list = postRepository.findAll()
    }

    override fun read(): Post? = if (nextIndex < list.size) list[nextIndex++] else null
}
