package com.haur.domain.commons

sealed class Result<out R> {
    class Success<T>(val data: T): Result<T>()
    class Error<T>(val error: ResourceError): Result<Nothing>()
}

fun <T> Result<T>.successOr(fallback: T): T {
    return (this as? Result.Success<T>)?.data ?: fallback
}