package com.example.springcachingkotlinsample.service

import com.example.springcachingkotlinsample.config.CachingConfig
import com.example.springcachingkotlinsample.constants.ErrorMessages
import com.example.springcachingkotlinsample.exceptions.NotFoundException
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CacheService(
    private val cachingConfig: CachingConfig
) {

    private val log = KotlinLogging.logger {}

    fun evictCache(cacheName: String) {
        cachingConfig.cacheManager().getCache(cacheName)?.clear()
            ?: throw NotFoundException(ErrorMessages.CACHE_NOT_FOUND).also {
                log.warn { "evictCache: cache name not found, cacheName=$cacheName" }
            }
    }

    fun getCacheNames(): Collection<String> {
        return cachingConfig.cacheManager().cacheNames
    }
}
