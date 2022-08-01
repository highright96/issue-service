package com.example.issueservice.handler

import com.example.issueservice.exception.ServerException
import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = KotlinLogging.logger {}

    companion object {
        private const val UNDEFINED_SERVER_ERROR_MESSAGE = "Server Undefined Internal Error."
    }

    @ExceptionHandler(ServerException::class)
    fun handleServerException(e: ServerException): ErrorResponse {
        logger.error { ErrorLogResponse(e.code, e.message, e.cause) }
        return ErrorResponse(e.code, e.message)
    }

    @ExceptionHandler(Exception::class)
    fun handleUndefinedException(e: Exception): ErrorResponse {
        logger.error { ErrorLogResponse(500, UNDEFINED_SERVER_ERROR_MESSAGE, e.cause) }
        return ErrorResponse(500, UNDEFINED_SERVER_ERROR_MESSAGE)
    }
}

data class ErrorResponse(
    val code: Int,
    val message: String
)

data class ErrorLogResponse(
    val code: Int,
    val message: String,
    val cause: Throwable?
)