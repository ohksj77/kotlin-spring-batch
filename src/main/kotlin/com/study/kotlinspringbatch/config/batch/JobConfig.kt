package com.study.kotlinspringbatch.config.batch

import com.study.kotlinspringbatch.post.Post
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JobConfig(
        private val stepBuilderFactory: StepBuilderFactory,
        private val jobBuilderFactory: JobBuilderFactory,
        private val batchConfig: BatchConfig
) {
    private final val BATCH_STEP: String = "BATCH_STEP"
    private final val BATCH_JOB: String = "BATCH_JOB"
    private final val CHUNK_SIZE: Int = 10

    @Bean
    fun job() : Job = jobBuilderFactory[BATCH_JOB]
                .start(step())
                .build()

    @Bean
    fun step() : Step = stepBuilderFactory[BATCH_STEP]
                .chunk<Post, Post>(CHUNK_SIZE)
                .reader(batchConfig.reader())
                .processor(batchConfig.processor())
                .writer(batchConfig.writer())
                .build()
}