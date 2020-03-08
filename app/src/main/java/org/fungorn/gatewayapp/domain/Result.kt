package org.fungorn.gatewayapp.domain

sealed class Result<T : Any> {
    class Loading<T : Any> : Result<T>()
    data class Success<T : Any>(val data: T) : Result<T>()
    data class Failure<T : Any>(val error: Throwable) : Result<T>()
}