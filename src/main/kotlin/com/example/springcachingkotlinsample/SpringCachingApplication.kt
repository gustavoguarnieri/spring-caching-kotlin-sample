package com.example.springcachingkotlinsample

import com.example.springcachingkotlinsample.constants.Products
import com.example.springcachingkotlinsample.repositories.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCachingKotlinSampleApplication(
	private val repository: ProductRepository
) : CommandLineRunner {

	override fun run(vararg args: String?) {
		repository.deleteAll()
		Products.productCatalog.forEach(repository::save)
	}
}

fun main(args: Array<String>) {
	runApplication<SpringCachingKotlinSampleApplication>(*args)
}
