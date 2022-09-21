package org.sjhstudio.sunflowerclone.data.local.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.sjhstudio.sunflowerclone.data.local.AppDatabase
import org.sjhstudio.sunflowerclone.data.local.model.GardenPlantingEntity
import org.sjhstudio.sunflowerclone.data.mapperToGardenPlantingEntity
import org.sjhstudio.sunflowerclone.data.mapperToPlantAndGardenPlantings
import org.sjhstudio.sunflowerclone.domain.model.GardenPlanting
import org.sjhstudio.sunflowerclone.domain.model.PlantAndGardenPlantings
import javax.inject.Inject

internal interface GardenPlantingLocalDataSource {

    suspend fun createGardenPlanting(plantId: String)

    suspend fun removeGardenPlanting(gardenPlanting: GardenPlanting)

    fun isPlanted(plantId: String): Flow<Boolean>

    fun getPlantedGardens(): Flow<List<PlantAndGardenPlantings>>
}

internal class GardenPlantingLocalDataSourceImpl @Inject constructor(
    private val database: AppDatabase
) : GardenPlantingLocalDataSource {

    override suspend fun createGardenPlanting(plantId: String) {
        val gardenPlantingEntity = GardenPlantingEntity(plantId)
        database.gardenPlantingDao().insertGardenPlanting(gardenPlantingEntity)
    }

    override suspend fun removeGardenPlanting(gardenPlanting: GardenPlanting) {
        database.gardenPlantingDao()
            .deleteGardenPlanting(mapperToGardenPlantingEntity(gardenPlanting))
    }

    override fun isPlanted(plantId: String): Flow<Boolean> {
        return database.gardenPlantingDao().isPlanted(plantId)
    }

    override fun getPlantedGardens(): Flow<List<PlantAndGardenPlantings>> {
        return database.gardenPlantingDao().getPlantedGardens().map { mapperToPlantAndGardenPlantings(it) }
    }
}