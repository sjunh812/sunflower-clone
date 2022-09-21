package org.sjhstudio.sunflowerclone.data.local.model

import androidx.room.Embedded
import androidx.room.Relation

data class PlantAndGardenPlantingsEntity(
    @Embedded val plantEntity: PlantEntity,
    @Relation(parentColumn = "id", entityColumn = "plant_id")
    val gardenPlantingEntities: List<GardenPlantingEntity> = emptyList()
)