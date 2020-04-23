package com.users.xucanyou666.wowsky.logic.network

import com.users.xucanyou666.wowsky.logic.model.DailyResponse
import com.users.xucanyou666.wowsky.logic.model.RealtimeResponse
import com.users.xucanyou666.wowsky.WoWSkyApplication
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("v2.5/${WoWSkyApplication.TOKEN}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(
        @Path("lng") lng: String,
        @Path("lat") lat: String
    ): Call<RealtimeResponse>

    @GET("v2.5/${WoWSkyApplication.TOKEN}/{lng},{lat}/daily.json")
    fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String): Call<DailyResponse>

}