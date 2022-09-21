package org.sjhstudio.sunflowerclone.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.sjhstudio.sunflowerclone.domain.model.Plant

@Entity(tableName = "plants")
data class PlantEntity(
    @PrimaryKey @ColumnInfo(name = "id") val plantId: String,
    val name: String,
    val description: String,
    val growZoneNumber: Int,
    val wateringInterval: Int = 7,
    val imageUrl: String = ""
) {
    fun toPlant(): Plant =
        Plant(plantId, name, description, growZoneNumber, wateringInterval, imageUrl)
}