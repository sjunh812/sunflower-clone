package org.sjhstudio.sunflowerclone.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import org.sjhstudio.sunflowerclone.data.local.model.PlantEntity

@Dao
interface PlantDao {

    @Query("SELECT * FROM plants ORDER BY name")
    fun getPlants(): Flow<List<PlantEntity>>

    @Query("SELECT * FROM plants WHERE growZoneNumber = :growZoneNumber ORDER BY name")
    fun getPlantsWithGrowZoneNumber(growZoneNumber: Int): Flow<List<PlantEntity>>

    @Query("SELECT * FROM plants WHERE id = :plantId")
    fun getPlant(plantId: String): Flow<PlantEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)    // Update
    suspend fun insertAll(plantEntities: List<PlantEntity>)
}