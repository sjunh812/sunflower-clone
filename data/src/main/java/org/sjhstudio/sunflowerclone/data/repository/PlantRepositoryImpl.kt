package org.sjhstudio.sunflowerclone.data.repository

import kotlinx.coroutines.flow.Flow
import org.sjhstudio.sunflowerclone.data.local.source.PlantLocalDataSource
import org.sjhstudio.sunflowerclone.domain.model.Plant
import org.sjhstudio.sunflowerclone.domain.repository.PlantRepository
import javax.inject.Inject

internal class PlantRepositoryImpl @Inject constructor(
    private val plantLocalDataSource: PlantLocalDataSource
) : PlantRepository {

    override fun getPlants(): Flow<List<Plant>> = plantLocalDataSource.getPlants()

    override fun getPlant(plantId: String): Flow<Plant> = plantLocalDataSource.getPlant(plantId)

    override fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): Flow<List<Plant>> =
        plantLocalDataSource.getPlantsWithGrowZoneNumber(growZoneNumber)
}