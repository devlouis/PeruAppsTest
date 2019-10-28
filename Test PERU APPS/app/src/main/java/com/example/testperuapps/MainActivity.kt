package com.example.testperuapps

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.example.testperuapps.ui.main.adapter.SectionsPagerAdapter
import com.example.testperuapps.ui.main.fragments.PostFragment
import com.example.testperuapps.ui.main.fragments.RoomFragment
import kotlinx.android.synthetic.main.activity_main.*







class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sectionsPagerAdapter = SectionsPagerAdapter(
            this,
            supportFragmentManager
        )
        sectionsPagerAdapter.addFragments(PostFragment(),"Post")
        sectionsPagerAdapter.addFragments(RoomFragment(),"PostRoom")


        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (position == 1)
                    (sectionsPagerAdapter.getItem(position) as RoomFragment).getAllPost()

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }



}