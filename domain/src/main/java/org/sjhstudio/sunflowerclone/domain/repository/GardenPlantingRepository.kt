package org.sjhstudio.sunflowerclone.domain.repository

import kotlinx.coroutines.flow.Flow
import org.sjhstudio.sunflowerclone.domain.model.GardenPlanting
import org.sjhstudio.sunflowerclone.domain.model.PlantAndGardenPlantings

interface GardenPlantingRepository {

    suspend fun createGardenPlanting(plantId: String)

    suspend fun removeGardenPlanting(gardenPlanting: GardenPlanting)

    fun isPlanted(plantId: String): Flow<Boolean>

    fun getPlantedGardens(): Flow<List<PlantAndGardenPlantings>>
}