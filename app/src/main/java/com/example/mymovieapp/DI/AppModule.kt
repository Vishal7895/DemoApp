package com.example.mymovieapp.DI

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import com.example.mymovieapp.Network.RetrofitClient
import com.example.mymovieapp.Remote.RestApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides

    fun provideAuthApi(
        remoteDataSource: RetrofitClient, @ApplicationContext context: Context
    ): RestApi {
        return remoteDataSource.buildApi(RestApi::class.java, context)
    }

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
}




