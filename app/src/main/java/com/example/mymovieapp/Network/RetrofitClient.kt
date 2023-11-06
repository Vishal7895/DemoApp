package com.example.mymovieapp.Network

import android.content.Context
import androidx.multidex.BuildConfig
import com.example.mymovieapp.R
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.Authenticator
import javax.inject.Inject

class RetrofitClient @Inject constructor() {
    private val BaseUrl="https://api.themoviedb.org/3/"
    fun <Api> buildApi(
        api: Class<Api>,
        context: Context,
    ): Api {

        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

    private fun getRetrofitClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    it.addHeader("Accept", "application/json")


                }.build())
            }.also {

               if (BuildConfig.DEBUG) {
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    it.addInterceptor(logging)
                }
            }.build()
    }

    /* val customBaseUrl = "https://custom.api.com/"
     val customRetrofit = Retrofit.Builder() .baseUrl(customBaseUrl) .addConverterFactory(GsonConverterFactory.create()) .build()
     val customApiService = customRetrofit.create(ApiService::class.java)*/
}