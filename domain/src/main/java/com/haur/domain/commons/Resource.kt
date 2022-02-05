package com.haur.domain.commons

sealed class Resource<T>(
    val data: T?,
    val error: ResourceError?
) {
    class Success<T>(val successData: T): Resource<T>(successData, null)
    class Error<T>(error: ResourceError): Resource<T>(null, error)
    class Progress<T>: Resource<T>(null, null)
}