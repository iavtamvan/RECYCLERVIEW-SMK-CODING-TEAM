package com.iavariav.myapplication.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.iavariav.myapplication.R
import com.iavariav.myapplication.adapter.RecyclerViewAdapter
import com.iavariav.myapplication.adapter.RecyclerViewMovieAdapter
import com.iavariav.myapplication.model.Item

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_movie, container, false)
        initView(view)
        return  view
    }
    private fun initData(){
        val name = resources.getStringArray(R.array.movie_name)
        val image = resources.obtainTypedArray(R.array.movie_image)

        items.clear()
        for (i in name.indices){
            items.add(
                Item(name[i],
                    image.getResourceId(i, 0)
                )
            )
        }

        image.recycle()
    }

    fun initView(view: View){
        initData()
        val rv = view.findViewById<RecyclerView>(R.id.rv_list_movie)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = activity?.let { RecyclerViewMovieAdapter(it, items) }
    }



}
