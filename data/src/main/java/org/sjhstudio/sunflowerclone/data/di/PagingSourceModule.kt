package org.sjhstudio.sunflowerclone.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.sunflowerclone.data.remote.api.UnsplashService
import org.sjhstudio.sunflowerclone.data.remote.source.UnsplashPagingSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object PagingSourceModule {

    @Singleton
    @Provides
    fun provideUnsplashPagingSource(service: UnsplashService, query: String): UnsplashPagingSource =
        UnsplashPagingSource(service, query)
}