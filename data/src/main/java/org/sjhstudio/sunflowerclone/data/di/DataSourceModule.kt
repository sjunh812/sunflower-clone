package org.sjhstudio.sunflowerclone.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sjhstudio.sunflowerclone.data.local.source.GardenPlantingLocalDataSource
import org.sjhstudio.sunflowerclone.data.local.source.GardenPlantingLocalDataSourceImpl
import org.sjhstudio.sunflowerclone.data.local.source.PlantLocalDataSource
import org.sjhstudio.sunflowerclone.data.local.source.PlantLocalDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface DataSourceModule {

    @Singleton
    @Binds
    fun bindPlantLocalDataSource(plantLocalDataSourceImpl: PlantLocalDataSourceImpl): PlantLocalDataSource

    @Singleton
    @Binds
    fun bindGardenPlantingLocalDataSource(gardenPlantingLocalDataSourceImpl: GardenPlantingLocalDataSourceImpl): GardenPlantingLocalDataSource
}