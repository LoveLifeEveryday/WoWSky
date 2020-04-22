package com.users.xucanyou666.wowsky.ui.place

import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView


/**
 * created by xucanyou666
 * on 2020/4/22 18:14
 * email：913710642@qq.com
 */
class PlaceTextWatcher(
    private val viewModel: PlaceViewModel,
    private val recyclerView: RecyclerView,
    private val adapter: PlaceAdapter
) : TextWatcher {
    override fun afterTextChanged(editable: Editable?) {
        val content = editable.toString()
        Log.d("Test", content)
        if (content.isNotEmpty()) {
            viewModel.searchPlaces(content)
        } else {
            recyclerView.visibility = View.GONE
            viewModel.placeList.clear()
            adapter.notifyDataSetChanged()
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}