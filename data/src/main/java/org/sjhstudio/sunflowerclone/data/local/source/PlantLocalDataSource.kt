package org.sjhstudio.sunflowerclone.data.local.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.sjhstudio.sunflowerclone.data.local.AppDatabase
import org.sjhstudio.sunflowerclone.data.local.dao.PlantDao
import org.sjhstudio.sunflowerclone.data.mapperToPlants
import org.sjhstudio.sunflowerclone.domain.model.Plant
import javax.inject.Inject

internal interface PlantLocalDataSource {

    fun getPlants(): Flow<List<Plant>>

    fun getPlant(plantId: String): Flow<Plant>

    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): Flow<List<Plant>>
}

internal class PlantLocalDataSourceImpl @Inject constructor(
    private val database: AppDatabase
) : PlantLocalDataSource {

    override fun getPlants(): Flow<List<Plant>> {
        return database.plantDao().getPlants().map { mapperToPlants(it) }
    }

    override fun getPlant(plantId: String): Flow<Plant> {
        return database.plantDao().getPlant(plantId).map { it.toPlant() }
    }

    override fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): Flow<List<Plant>> {
        return database.plantDao().getPlantsWithGrowZoneNumber(growZoneNumber).map { mapperToPlants(it) }
    }
}