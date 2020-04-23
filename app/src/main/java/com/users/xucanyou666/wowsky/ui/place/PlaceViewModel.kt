package com.users.xucanyou666.wowsky.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.users.xucanyou666.wowsky.logic.Repository
import com.users.xucanyou666.wowsky.logic.model.Place


/**
 * 原则上与界面相关的数据都放到 ViewModel 中
 * created by xucanyou666
 * on 2020/4/22 17:01
 * email：913710642@qq.com
 */

class PlaceViewModel : ViewModel() {
    private val searchLiveData = MutableLiveData<String>()

    /**
     * 对界面上显示的数据进行缓存，避免旋转的时候发生数据丢失
     */
    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavedPlace() = Repository.getSavedPlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()
}