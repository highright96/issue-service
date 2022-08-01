package com.example.issueservice.exception

sealed class ServerException(
    val code: Int,
    override val message: String,
    override val cause: Throwable?
) : RuntimeException(message, cause) {
    data class NotFoundException(
        override val message: String,
        override val cause: Throwable? = null
    ) : ServerException(404, message, cause)

    data class UnauthorizedException(
        override val message: String = "Token is invalid.",
        override val cause: Throwable? = null
    ) : ServerException(401, message, cause)

    data class InternalException(
        override val message: String = "Internal Server Error.",
        override val cause: Throwable? = null
    ) : ServerException(500, message, cause)
}
