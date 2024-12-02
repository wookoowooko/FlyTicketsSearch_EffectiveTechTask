package io.wookoo.flyticketssearch.data.repo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.io.IOException

fun <T> Response<T>.asFlow(): Flow<T> = flow {
    if (isSuccessful) {
        val responseBody = body()
        if (responseBody != null) {
            emit(responseBody)
        } else {
            throw IOException("Response body is null")
        }
    } else {
        throw IOException("Error: ${code()} - ${message()}")
    }
}
