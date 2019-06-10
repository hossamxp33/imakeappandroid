package com.example.android.slider


import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var currentPage: Int = 0
    var NUM_PAGES: Int = 5
    lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        viewpager.adapter = ViewPagerAdapter()
        indicator.setViewPager(viewpager)
        swipeViewPager()
    }

    fun swipeViewPager() {
        val handler = Handler()
        val update = Runnable() {
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            viewpager.setCurrentItem(currentPage++, true)
        }
        val swipTimer = Timer()
        swipTimer.schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }
            , 50, 3000)

    }
}