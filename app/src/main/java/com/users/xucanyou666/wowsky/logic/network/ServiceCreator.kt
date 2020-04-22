package com.users.xucanyou666.wowsky.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * 担当 Retrofit 接口工具的一个角色
 *
 * created by xucanyou666
 * on 2020/4/22 16:20
 * email：913710642@qq.com
 */
object ServiceCreator {
    private const val BASE_URL = "https://api.caiyunapp.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    /**
     * 简化调用
     */
    inline fun <reified T> create(): T = create(T::class.java)
}