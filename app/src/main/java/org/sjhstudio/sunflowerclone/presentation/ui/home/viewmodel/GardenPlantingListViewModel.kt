package org.sjhstudio.sunflowerclone.presentation.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sjhstudio.sunflowerclone.domain.repository.GardenPlantingRepository
import javax.inject.Inject

@HiltViewModel
class GardenPlantingListViewModel @Inject constructor(
    private val gardenPlantingRepository: GardenPlantingRepository
) : ViewModel() {

    val plantAndGardenPlantings = gardenPlantingRepository.getPlantedGardens()
}