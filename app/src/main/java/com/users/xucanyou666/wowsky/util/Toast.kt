package com.users.xucanyou666.wowsky.util

import android.content.Context
import android.widget.Toast


/**
 * created by xucanyou666
 * on 2020/4/22 18:31
 * email：913710642@qq.com
 */

fun String.showToast(context: Context?, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this, duration).show()
}

fun Int.showToast(context: Context, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, this, duration).show()
}
