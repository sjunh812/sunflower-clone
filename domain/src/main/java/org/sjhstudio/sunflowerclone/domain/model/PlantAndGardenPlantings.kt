package org.sjhstudio.sunflowerclone.domain.model

data class PlantAndGardenPlantings(
    val plant: Plant,
    val gardenPlantings: List<GardenPlanting> = emptyList()
)