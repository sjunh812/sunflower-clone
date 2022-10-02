package org.sjhstudio.sunflowerclone.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.sunflowerclone.data.repository.GardenPlantingRepositoryImpl
import org.sjhstudio.sunflowerclone.data.repository.PlantRepositoryImpl
import org.sjhstudio.sunflowerclone.data.repository.UnsplashRepositoryImpl
import org.sjhstudio.sunflowerclone.domain.repository.GardenPlantingRepository
import org.sjhstudio.sunflowerclone.domain.repository.PlantRepository
import org.sjhstudio.sunflowerclone.domain.repository.UnsplashRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface RepositoryModule {

    @Singleton
    @Binds
    fun bindPlantRepository(plantRepositoryImpl: PlantRepositoryImpl): PlantRepository

    @Singleton
    @Binds
    fun bindGardenPlantingRepository(gardenPlantingRepositoryImpl: GardenPlantingRepositoryImpl): GardenPlantingRepository

    @Singleton
    @Binds
    fun bindUnsplashRepository(unsplashRepositoryImpl: UnsplashRepositoryImpl): UnsplashRepository
}