package io.jeffchang.buttondemo.di.modules

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import io.jeffchang.buttondemo.network.remote.FakeButtonService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Provides dependency injection for networking singletons.
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideFakeButtonService(retrofit: Retrofit): FakeButtonService {
        return retrofit.create(FakeButtonService::class.java)
    }

    companion object {
        private const val BASE_URL = "http://fake-button.herokuapp.com/"
    }
}
