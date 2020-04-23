package com.users.xucanyou666.wowsky.util

import android.content.Context
import android.content.Intent


/**
 * created by xucanyou666
 * on 2020/4/23 15:15
 * email：913710642@qq.com
 */


/**
 * 不传参数的 startActivity 写法
 *
 * 使用：startActivity<WeatherActivity>(context)
 *
 */
inline fun <reified T> startActivity(context: Context?) {
    val intent = Intent(context, T::class.java)
    context?.startActivity(intent)
}

/**
 * 传参数的 startActivity 写法
 *
 * 使用：
 * startActivity<WeatherActivity>(context) {
putExtra("location_lng", place.location.lng)
putExtra("location_lat", place.location.lat)
putExtra("place_name", place.name)
}
 */
inline fun <reified T> startActivity(context: Context?, block: Intent.() -> Unit) {
    val intent = Intent(context, T::class.java)
    intent.block()
    context?.startActivity(intent)
}