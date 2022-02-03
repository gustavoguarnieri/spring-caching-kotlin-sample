package com.example.springcachingkotlinsample.config

import com.example.springcachingkotlinsample.constants.CacheNames.Companion.CACHE_PRODUCTS
import mu.KotlinLogging
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled

@Configuration
@EnableCaching
@EnableScheduling
class CachingConfig {

    private val log = KotlinLogging.logger {}

    @Bean
    fun cacheManager(): CacheManager {
        val cacheManager = SimpleCacheManager()
        cacheManager.setCaches(
            listOf(
                ConcurrentMapCache(CACHE_PRODUCTS)
            )
        )
        return cacheManager
    }

    @CacheEvict(value = [CACHE_PRODUCTS], allEntries = true)
    @Scheduled(fixedRate = ONE_HOUR_IN_MILLISECONDS)
    fun evictCaches() {
        log.info("evictCaches: caches evict after $ONE_HOUR_IN_MILLISECONDS milliseconds running")
    }

    companion object {
        private const val ONE_MINUTE_IN_MILLISECONDS = 60L * 1000L
        private const val ONE_HOUR_IN_MILLISECONDS = 60L * ONE_MINUTE_IN_MILLISECONDS
    }
}
