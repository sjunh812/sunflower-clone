package org.sjhstudio.sunflowerclone.data.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import org.sjhstudio.sunflowerclone.data.local.AppDatabase
import org.sjhstudio.sunflowerclone.data.local.model.PlantEntity
import org.sjhstudio.sunflowerclone.domain.model.Plant
import javax.inject.Inject

@HiltWorker
class SeedDatabaseWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    @Inject
    lateinit var database: AppDatabase

    override suspend fun doWork(): Result = withContext(IO) {
        try {
            val filename = inputData.getString(KEY_FILENAME)
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
            val listType = Types.newParameterizedType(List::class.java, PlantEntity::class.java)
            val adapter: JsonAdapter<List<PlantEntity>> = moshi.adapter(listType)

            if (filename != null) {
                val json = applicationContext.assets.open(filename).bufferedReader().use {
                    it.readText()
                }
                val plantList = adapter.fromJson(json)
                if (plantList != null) {
                    database.plantDao().insertAll(plantList)
                    Result.success()
                } else {
                    Result.failure()
                }
            } else {
                Log.e(TAG, "Error seeding database - no valid filename")
                Result.failure()
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error seeding database", e)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "SeedDatabaseWorker"
        const val KEY_FILENAME = "PLANT_DATE_FILENAME"
    }
}