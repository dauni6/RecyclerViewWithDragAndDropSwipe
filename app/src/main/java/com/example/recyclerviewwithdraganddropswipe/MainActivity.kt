package com.example.recyclerviewwithdraganddropswipe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewwithdraganddropswipe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: TabListAdapter
    private lateinit var mItemTouchHelper: ItemTouchHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mAdapter = TabListAdapter()
        mItemTouchHelper = ItemTouchHelper(ItemTouchHelperCallback().apply {
            setListener(mAdapter)
        })
        binding.rvTabList.apply {
            layoutManager = LinearLayoutManager(
                applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = mAdapter
            mItemTouchHelper.attachToRecyclerView(this)
            mAdapter.setItems(makeTabList())
        }
    }

    private fun makeTabList(): ArrayList<TabItem> {
        val items = arrayListOf<TabItem>()
        items.add(TabItem("SUBSCRIBE", 0))
        items.add(TabItem("BEST", 0))
        items.add(TabItem("MUSIC", 0))
        items.add(TabItem("SPORTS", 0))
        items.add(TabItem("GAME", 0))
        items.add(TabItem("MOVIE", 0))
        items.add(TabItem("NEWS", 0))
        items.add(TabItem("LIVE", 0))
        return items
    }

}
