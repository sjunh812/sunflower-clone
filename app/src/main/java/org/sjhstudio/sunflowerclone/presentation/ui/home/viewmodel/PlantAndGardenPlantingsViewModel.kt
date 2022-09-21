package org.sjhstudio.sunflowerclone.presentation.ui.home.viewmodel

import org.sjhstudio.sunflowerclone.domain.model.PlantAndGardenPlantings
import java.text.SimpleDateFormat
import java.util.*


class PlantAndGardenPlantingsViewModel(plantings: PlantAndGardenPlantings) {

    private val plant = checkNotNull(plantings.plant)
    private val gardenPlanting = plantings.gardenPlantings[0]

    val waterDateString = dateFormat.format(gardenPlanting.lastWateringDate.time)
    val wateringInterval = plant.wateringInterval
    val imageUrl = plant.imageUrl
    val plantName = plant.name
    val plantDateString = dateFormat.format(gardenPlanting.plantDate.time)
    val plantId = plant.plantId

    companion object {
        private val dateFormat = SimpleDateFormat("MMM d, yyyy", Locale.KOREA)
    }
}