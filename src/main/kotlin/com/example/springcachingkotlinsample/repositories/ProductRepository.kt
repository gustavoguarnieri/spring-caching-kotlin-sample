package com.example.springcachingkotlinsample.repositories

import com.example.springcachingkotlinsample.model.entities.ProductEntity
import org.springframework.data.mongodb.repository.MongoRepository
import java.math.BigInteger

interface ProductRepository : MongoRepository<ProductEntity, String> {
    fun findById(id: BigInteger): ProductEntity?
}
