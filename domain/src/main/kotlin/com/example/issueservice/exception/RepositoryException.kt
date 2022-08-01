package com.example.issueservice.exception

import arrow.core.Either
import arrow.core.getOrHandle

sealed class RepositoryException(
    open val message: String,
    open val cause: Throwable?
) {
    fun convert() =
        when (this) {
            is RecordNotFoundException -> ServerException.NotFoundException(message, cause)
            is DatabaseInternalException -> ServerException.InternalException(message, cause)
        }

    data class RecordNotFoundException(
        override val message: String,
        override val cause: Throwable? = null
    ) : RepositoryException(message, cause)

    data class DatabaseInternalException(
        override val message: String = "Database Internal Error",
        override val cause: Throwable? = null
    ) : RepositoryException(message, cause)
}

fun <T> Either<RepositoryException, T>.unwrap(): T =
    getOrHandle { throw it.convert() }