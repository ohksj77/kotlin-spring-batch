package com.study.kotlinspringbatch

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EnableBatchProcessing
@SpringBootApplication
class KotlinSpringBatchApplication

fun main(args: Array<String>) {
	runApplication<KotlinSpringBatchApplication>(*args)
}
