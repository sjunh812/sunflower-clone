package org.sjhstudio.sunflowerclone.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.sjhstudio.sunflowerclone.data.local.model.GardenPlantingEntity
import org.sjhstudio.sunflowerclone.data.local.model.PlantAndGardenPlantingsEntity

@Dao
interface GardenPlantingDao {

    @Query("SELECT * FROM garden_plantings")
    fun getGardenPlanting(): Flow<List<GardenPlantingEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM garden_plantings WHERE plant_id = :plantId LIMIT 1)")
    fun isPlanted(plantId: String): Flow<Boolean>

    /**
     * 해당 쿼리는 [Plant]와 [GardenPlantingEntity] 테이블을 동시에 다루고 있음
     * 결과값으로 매핑된 객체를 이용
     */
    @Transaction
    @Query("SELECT * FROM plants WHERE id IN (SELECT DISTINCT(plant_id) FROM garden_plantings)")
    fun getPlantedGardens(): Flow<List<PlantAndGardenPlantingsEntity>>

    @Insert
    suspend fun insertGardenPlanting(gardenPlantingEntity: GardenPlantingEntity): Long

    @Delete
    suspend fun deleteGardenPlanting(gardenPlantingEntity: GardenPlantingEntity)
}