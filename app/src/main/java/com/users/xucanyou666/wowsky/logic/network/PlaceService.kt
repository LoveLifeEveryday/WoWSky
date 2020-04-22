package com.users.xucanyou666.wowsky.logic.network

import com.users.xucanyou666.wowsky.WoWSkyApplication
import com.users.xucanyou666.wowsky.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Retrofit 的接口
 *
 * created by xucanyou666
 * on 2020/4/22 16:15
 * email：913710642@qq.com
 */
interface PlaceService {
    @GET("v2/place?token=${WoWSkyApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}