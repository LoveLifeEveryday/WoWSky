package com.users.xucanyou666.wowsky.logic.model

import com.google.gson.annotations.SerializedName


/**
 * 实体类
 *
 * created by xucanyou666
 * on 2020/4/22 16:10
 * email：913710642@qq.com
 */

/**
 * status : ok
 * query : 广州
 * places : [{"id":"1eab06e98e9d9a81941d427c1ead4ece2f75ed67","location":{"lat":23.12911,"lng":113.264385},"place_id":"g-1eab06e98e9d9a81941d427c1ead4ece2f75ed67","name":"广州市","formatted_address":"中国广东省广州市"},{"id":"B00141JEHS","name":"广州市","formatted_address":"中国 广东省 广州市 越秀区 越秀区","location":{"lat":23.129112,"lng":113.264385},"place_id":"a-B00141JEHS"},{"id":"B001408CE4","name":"广州石化","formatted_address":"中国 广东省 广州市 黄埔区 石化路176号","location":{"lat":23.137791,"lng":113.47024},"place_id":"a-B001408CE4"},{"id":"B001406A63","name":"广州石化","formatted_address":"中国 广东省 广州市 黄埔区 石化路550号","location":{"lat":23.121117,"lng":113.479865},"place_id":"a-B001406A63"},{"id":"B00141JJWP","name":"苹果(中国)广州总部","formatted_address":"中国 广东省 广州市 白云区 明珠东路3号","location":{"lat":23.198146,"lng":113.276795},"place_id":"a-B00141JJWP"}]
 */

data class PlaceResponse(val status: String, val places: List<Place>)
data class Place(
    val name: String,
    val location: Location,
    //这里的 SerializedName 是为了使 json 和 Kotlin 间形成映射关系
    @SerializedName("formatted_address") val address: String
)

data class Location(val lng: String, val lat: String)