package org.sjhstudio.sunflowerclone.data

import org.sjhstudio.sunflowerclone.data.local.model.GardenPlantingEntity
import org.sjhstudio.sunflowerclone.data.local.model.PlantAndGardenPlantingsEntity
import org.sjhstudio.sunflowerclone.data.local.model.PlantEntity
import org.sjhstudio.sunflowerclone.domain.model.GardenPlanting
import org.sjhstudio.sunflowerclone.domain.model.Plant
import org.sjhstudio.sunflowerclone.domain.model.PlantAndGardenPlantings

fun mapperToPlants(plants: List<PlantEntity>): List<Plant> =
    plants.toList().map {
        it.toPlant()
    }

fun mapperToGardenPlantingEntity(gardenPlanting: GardenPlanting): GardenPlantingEntity =
    GardenPlantingEntity(
        plantId = gardenPlanting.plantId,
        plantDate = gardenPlanting.plantDate,
        lastWateringDate = gardenPlanting.lastWateringDate
    )

fun mapperToGardenPlantings(gardenPlantings: List<GardenPlantingEntity>): List<GardenPlanting> =
    gardenPlantings.toList().map {
        it.toGardenPlanting()
    }

fun mapperToPlantAndGardenPlantings(plantAndGardenPlantings: List<PlantAndGardenPlantingsEntity>): List<PlantAndGardenPlantings> =
    plantAndGardenPlantings.toList().map {
        PlantAndGardenPlantings(
            plant = it.plantEntity.toPlant(),
            gardenPlantings = mapperToGardenPlantings(it.gardenPlantingEntities)
        )
    }