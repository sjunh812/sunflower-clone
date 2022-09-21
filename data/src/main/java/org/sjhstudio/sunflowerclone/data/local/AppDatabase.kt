package org.sjhstudio.sunflowerclone.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.sjhstudio.sunflowerclone.data.local.dao.GardenPlantingDao
import org.sjhstudio.sunflowerclone.data.local.dao.PlantDao
import org.sjhstudio.sunflowerclone.data.local.model.GardenPlantingEntity
import org.sjhstudio.sunflowerclone.data.local.model.PlantEntity

@Database(entities = [GardenPlantingEntity::class, PlantEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun gardenPlantingDao(): GardenPlantingDao
    abstract fun plantDao(): PlantDao
}