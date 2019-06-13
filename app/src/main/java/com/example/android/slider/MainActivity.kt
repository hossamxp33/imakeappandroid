package com.example.android.slider


import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
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
        viewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        viewModel.swipeViewPager()
        viewModel.viewPager!!.observe(this , android.arch.lifecycle.Observer{
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            viewpager.setCurrentItem(currentPage++, true)

        })

    }



}