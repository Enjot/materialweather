package com.enjot.materialweather.data.background

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.enjot.materialweather.domain.usecase.FetchAndStoreWeatherUseCase
import com.enjot.materialweather.domain.usecase.GetLocalWeatherUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first

@HiltWorker
class UpdateWeatherWorker @AssistedInject constructor(
    private val fetchAndStoreWeatherUseCase: FetchAndStoreWeatherUseCase,
    private val getLocalWeatherUseCase: GetLocalWeatherUseCase,
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
) : CoroutineWorker(appContext, workerParams) {
    override suspend fun doWork(): Result {
        return try {
            val weatherInfo = getLocalWeatherUseCase().first()
            val coordinates = weatherInfo!!.place!!.coordinates
            fetchAndStoreWeatherUseCase(coordinates)
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}