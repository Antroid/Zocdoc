package com.zocdoc.zocdoc.di.modules

import com.zocdoc.zocdoc.Consts.Companion.MOVIES_BASE_URL
import com.zocdoc.zocdoc.services.MovieService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ApplicationModule {

    private fun getOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .addInterceptor(logging)
            .build()
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(): Retrofit {

        return Retrofit.Builder().baseUrl(MOVIES_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient())
            .build()
    }

    @Singleton
    @Provides
    internal fun provideRetrofitService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

}