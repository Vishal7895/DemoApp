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
    private val authToken ="eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIzY2I0NDQ0MDE5ZjI3YWViM2U1NDk1N2IzNjlmNzZjNSIsInN1YiI6IjY1NDM0MjM3ZTFhZDc5MDEyYzkwZmI4MyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.gv00iOlMEIAE39UjmIn2GTf_UciGZaUGqnmNWSK-l-I"

    fun <Api> buildApi(
        api: Class<Api>,
        context: Context,
    ): Api {

        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .client(getRetrofitClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }

    private fun getRetrofitClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain.request().newBuilder().also {
                    it.addHeader("accept", "application/json")
                        .addHeader("Authorization","Bearer $authToken")



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