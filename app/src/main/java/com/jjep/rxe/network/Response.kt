package com.jjep.rxe.network

sealed class Response<T> {
    companion object {
        fun <T> loading(loading: Boolean): Response<T> = Progress(loading)
        fun <T> success(data: T): Response<T> = Success(data)
        fun <T> failure(e: Throwable): Response<T> = Failure(e)
    }

    data class Progress<T>(var loading: Boolean) : Response<T>()
    data class Success<T>(var data: T) : Response<T>()
    data class Failure<T>(var e: Throwable) : Response<T>()
}