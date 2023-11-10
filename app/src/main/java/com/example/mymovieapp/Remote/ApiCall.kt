package com.example.mymovieapp.Remote

import com.example.mymovieapp.DTO.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

interface ApiCall {
    suspend fun <T> apiCall(apiCall: suspend () -> T): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                Resource.success(apiCall.invoke(),"")
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        Resource.error(throwable.message, null, throwable.message()+"")
                    }
                    else -> {
                        Resource.error(throwable.message, null, throwable.message+"")
                    }
                }
            }
        }
    }
}