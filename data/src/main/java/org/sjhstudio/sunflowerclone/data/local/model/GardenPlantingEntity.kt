package org.sjhstudio.sunflowerclone.data.local.model

import androidx.room.*
import org.sjhstudio.sunflowerclone.domain.model.GardenPlanting
import java.util.*

@Entity(
    tableName = "garden_plantings",
    foreignKeys = [
        ForeignKey(
            entity = PlantEntity::class,
            parentColumns = ["id"],
            childColumns = ["plant_id"]
        )
    ],
    indices = [Index("plant_id")]   // 쿼리속도를 높이기 위한 컬럼 인덱스화
)
data class GardenPlantingEntity(
    @ColumnInfo(name = "plant_id") val plantId: String,
    @ColumnInfo(name = "plant_date") val plantDate: Calendar = Calendar.getInstance(),
    @ColumnInfo(name = "last_watering_date") val lastWateringDate: Calendar = Calendar.getInstance()
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var gardenPlantingId: Long = 0

    fun toGardenPlanting(): GardenPlanting = GardenPlanting(plantId, plantDate, lastWateringDate)
}