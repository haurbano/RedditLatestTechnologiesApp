package com.haur.domain.commons

sealed class ResourceError {
    object NetworkError: ResourceError()
    object UnknownError: ResourceError()
}