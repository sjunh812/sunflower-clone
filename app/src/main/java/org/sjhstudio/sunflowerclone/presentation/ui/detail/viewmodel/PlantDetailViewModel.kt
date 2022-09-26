package org.sjhstudio.sunflowerclone.presentation.ui.detail.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.sjhstudio.sunflowerclone.domain.model.Plant
import org.sjhstudio.sunflowerclone.domain.repository.GardenPlantingRepository
import org.sjhstudio.sunflowerclone.domain.repository.PlantRepository
import javax.inject.Inject

@HiltViewModel
class PlantDetailViewModel @Inject constructor(
    plantRepository: PlantRepository,
    private val gardenPlantingRepository: GardenPlantingRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val plantId: String = savedStateHandle["plantId"] ?: throw IllegalStateException()
    val isPlanted = gardenPlantingRepository.isPlanted(plantId)
    val plant = plantRepository.getPlant(plantId).stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        Plant.EMPTY
    )

    private val _showSnackbar = MutableStateFlow(false)
    val showSnackbar = _showSnackbar.asStateFlow()

    fun addPlantToGarden() = viewModelScope.launch {
        gardenPlantingRepository.createGardenPlanting(plantId)
        _showSnackbar.value = true
    }

    fun dismissSnackbar() {
        _showSnackbar.value = false
    }
}