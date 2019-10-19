package com.iavariav.myapplication.fragment

import `in`.mayanknagwanshi.imagepicker.ImageSelectActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.iavariav.myapplication.R
import com.iavariav.myapplication.model.Item
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.app.Activity
import android.widget.ImageView
import com.iavariav.myapplication.adapter.RecyclerViewMovieAdapter


/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    private var items: MutableList<Item> = mutableListOf()
    lateinit var imageResult:ImageView;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_movie, container, false)
        initView(view)
        imageResult = view.findViewById(R.id.iv_resul);
        val btn = view.findViewById<Button>(R.id.btn_image_picker);
        btn.setOnClickListener {
            val intent = Intent(activity, ImageSelectActivity::class.java)
            intent.putExtra(ImageSelectActivity.FLAG_COMPRESS, false)//default is true
            intent.putExtra(ImageSelectActivity.FLAG_CAMERA, true)//default is true
            intent.putExtra(ImageSelectActivity.FLAG_GALLERY, true)//default is true
            startActivityForResult(intent, 1213)
        }


        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1213 && resultCode == Activity.RESULT_OK) {
            val filePath = data!!.getStringExtra(ImageSelectActivity.RESULT_FILE_PATH)
            val selectedImage = BitmapFactory.decodeFile(filePath)
            imageResult.setImageBitmap(selectedImage)
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.movie_name)
        val image = resources.obtainTypedArray(R.array.movie_image)

        items.clear()
        for (i in name.indices) {
            items.add(
                Item(
                    name[i],
                    image.getResourceId(i, 0)
                )
            )
        }

        image.recycle()
    }

    fun initView(view: View) {
        initData()
        val rv = view.findViewById<RecyclerView>(R.id.rv_list_movie)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.adapter = activity?.let { RecyclerViewMovieAdapter(it, items) }
    }


}
