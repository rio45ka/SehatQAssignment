package com.auroraministudio.sehatqassignment.di

import android.app.Application
import android.content.Context
import com.auroraministudio.sehatqassignment.data.services.SehatQApi
import com.auroraministudio.sehatqassignment.utils.Const
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttp(@ApplicationContext appContext: Context): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
            .cache(Cache(appContext.cacheDir, Const.CACHE_SIZE))
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )

        return builder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(application: Application): SehatQApi {
        return Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .client(provideOkHttp(application))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SehatQApi::class.java)
    }

}