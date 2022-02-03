package com.example.springcachingkotlinsample.exceptions

import com.example.springcachingkotlinsample.constants.ErrorMessages.Companion.NO_DATA_FOUND
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException(message: String) : RuntimeException(message.ifBlank { NO_DATA_FOUND })
