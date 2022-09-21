package org.sjhstudio.sunflowerclone.data.repository

import kotlinx.coroutines.flow.Flow
import org.sjhstudio.sunflowerclone.data.local.source.GardenPlantingLocalDataSource
import org.sjhstudio.sunflowerclone.domain.model.GardenPlanting
import org.sjhstudio.sunflowerclone.domain.model.PlantAndGardenPlantings
import org.sjhstudio.sunflowerclone.domain.repository.GardenPlantingRepository
import javax.inject.Inject

internal class GardenPlantingRepositoryImpl @Inject constructor(
    private val gardenPlantingLocalDataSource: GardenPlantingLocalDataSource
) : GardenPlantingRepository {

    override suspend fun createGardenPlanting(plantId: String) {
        gardenPlantingLocalDataSource.createGardenPlanting(plantId)
    }

    override suspend fun removeGardenPlanting(gardenPlanting: GardenPlanting) {
        gardenPlantingLocalDataSource.removeGardenPlanting(gardenPlanting)
    }

    override fun isPlanted(plantId: String): Flow<Boolean> {
        return gardenPlantingLocalDataSource.isPlanted(plantId)
    }

    override fun getPlantedGardens(): Flow<List<PlantAndGardenPlantings>> {
        return gardenPlantingLocalDataSource.getPlantedGardens()
    }
}