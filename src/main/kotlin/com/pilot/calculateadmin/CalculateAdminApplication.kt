package com.pilot.calculateadmin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean::class)
@SpringBootApplication
class CalculateAdminApplication

fun main(args: Array<String>) {
	runApplication<CalculateAdminApplication>(*args)
}
