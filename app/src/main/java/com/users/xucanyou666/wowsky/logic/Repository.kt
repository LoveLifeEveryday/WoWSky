package com.users.xucanyou666.wowsky.logic

import androidx.lifecycle.liveData
import com.users.xucanyou666.wowsky.logic.model.Place
import com.users.xucanyou666.wowsky.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext


/**
 *
 *
 * created by xucanyou666
 * on 2020/4/22 16:36
 * email：913710642@qq.com
 */
object Repository {
    fun searchPlaces(query: String) = fire(Dispatchers.IO) {
        val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
        if (placeResponse.status == "ok") {
            val places = placeResponse.places
            Result.success(places)
        } else {
            Result.failure(RuntimeException("response status is ${placeResponse.status}"))
        }
    }
    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}