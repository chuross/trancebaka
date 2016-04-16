package com.github.chuross.trancebaka.application

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton
import com.github.chuross.trancebaka.infrastructure.soundcloud.Api as SoundCloudApi


@Module
class ApplicationModule(application: Application) {

    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(application.requestContext.baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun providesSoundCloudApi() = retrofit.create(SoundCloudApi::class.java)
}