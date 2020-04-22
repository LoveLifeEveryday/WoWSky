package com.users.xucanyou666.wowsky.ui.place

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.users.xucanyou666.wowsky.R
import com.users.xucanyou666.wowsky.logic.model.Place
import com.users.xucanyou666.wowsky.util.showToast
import kotlinx.android.synthetic.main.fragment_place.*


/**
 * created by xucanyou666
 * on 2020/4/22 18:05
 * email：913710642@qq.com
 */
class PlaceFragment : Fragment() {
    val viewModel by lazy { ViewModelProvider(this)[PlaceViewModel::class.java] }
    private lateinit var adapter: PlaceAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_place, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager
        adapter = PlaceAdapter(this, viewModel.placeList)
        recyclerView.adapter = adapter
        searchPlaceEdit.addTextChangedListener(PlaceTextWatcher(viewModel, recyclerView, adapter))

        viewModel.placeLiveData.observe(this, Observer { result ->
            // getOrNull 的意思是：如果实例表示 Result.isSuccess ，返回封装的值，否则返回 null
            val places = result.getOrNull()
            if (places != null) {
                recyclerView.visibility = View.VISIBLE
                bgImageView.visibility = View.GONE
                viewModel.placeList.clear()
                viewModel.placeList.addAll(places as Collection<Place>)
                adapter.notifyDataSetChanged()
            } else {
                "未能查询到任何地点".showToast(activity)
                result.exceptionOrNull()?.printStackTrace()
            }
        })
    }
}