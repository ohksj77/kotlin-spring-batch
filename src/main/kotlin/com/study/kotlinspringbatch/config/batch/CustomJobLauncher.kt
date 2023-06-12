package com.study.kotlinspringbatch.config.batch

import org.springframework.batch.core.JobParameter
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class CustomJobLauncher(
        private val jobLauncher: JobLauncher,
        private val jobConfig: JobConfig,
) {
    private var num: Long = 0

    @Scheduled(initialDelay = 3000, fixedDelay = 5000)
    fun run() = jobLauncher.run(jobConfig.job(), JobParameters(mutableMapOf(LocalDateTime.now().toString() to JobParameter(num++, true))))
}
