package com.users.xucanyou666.wowsky

import android.app.Application
import android.content.Context


/**
 * created by xucanyou666
 * on 2020/4/22 15:36
 * email：913710642@qq.com
 */
class WoWSkyApplication : Application() {
    companion object {
        const val TOKEN = "g9q3hoe3DdeT82CY"
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}