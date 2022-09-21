package org.sjhstudio.sunflowerclone.domain.model

import java.util.*

class GardenPlanting(
    val plantId: String,
    val plantDate: Calendar = Calendar.getInstance(),
    val lastWateringDate: Calendar = Calendar.getInstance()
)