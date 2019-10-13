package com.iavariav.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.iavariav.myapplication.adapter.RecyclerViewAdapter
import com.iavariav.myapplication.model.Item
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)

        items.clear()
        for (i in name.indices){
            items.add(Item(name[i],
                image.getResourceId(i, 0)
                ))
        }

        image.recycle()
    }

    fun initView(){
        initData()
        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = RecyclerViewAdapter(this, items)
    }
}
