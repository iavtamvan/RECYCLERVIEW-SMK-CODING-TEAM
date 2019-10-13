package com.iavariav.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.iavariav.myapplication.adapter.RecyclerViewAdapter
import com.iavariav.myapplication.fragment.TeamFragment
import com.iavariav.myapplication.model.Item
import com.ogaclejapan.smarttablayout.SmartTabLayout
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = FragmentPagerItemAdapter(
            supportFragmentManager, FragmentPagerItems.with(this)
                .add("Team", TeamFragment::class.java)
                .add("Movie", TeamFragment::class.java)
                .create()
        )
        val viewPager = findViewById<View>(R.id.viewpager) as ViewPager
        viewPager.adapter = adapter

        val viewPagerTab = findViewById<View>(R.id.viewpagertab) as SmartTabLayout
        viewPagerTab.setViewPager(viewPager)


    }

}
