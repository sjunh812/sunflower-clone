package org.sjhstudio.sunflowerclone.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.sunflowerclone.data.remote.api.UnsplashService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    @Singleton
    @Provides
    fun provideUnsplashService(retrofit: Retrofit): UnsplashService {
        return retrofit.create(UnsplashService::class.java)
    }
}