package com.study.kotlinspringbatch.config.batch

import com.study.kotlinspringbatch.post.Post
import com.study.kotlinspringbatch.post.PostRepository
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.item.ItemProcessor
import org.springframework.batch.item.ItemReader
import org.springframework.batch.item.ItemWriter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BatchConfig(
        private val postRepository: PostRepository,
        private val customItemReader: CustomItemReader
) {
    @Bean
    @StepScope
    fun reader() : ItemReader<Post?> = customItemReader

    @Bean
    fun processor() : ItemProcessor<Post?, Post> = ItemProcessor {
        it.let {
            it.update()
            it
        }
    }

    @Bean
    fun writer() : ItemWriter<Post> = ItemWriter {
        postRepository.saveAll(it)
    }
}
