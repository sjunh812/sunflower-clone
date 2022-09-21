package org.sjhstudio.sunflowerclone.domain.repository

import kotlinx.coroutines.flow.Flow
import org.sjhstudio.sunflowerclone.domain.model.Plant

interface PlantRepository {

    fun getPlants(): Flow<List<Plant>>

    fun getPlant(plantId: String): Flow<Plant>

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): Flow<List<Plant>>
}