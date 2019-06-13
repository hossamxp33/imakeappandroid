package com.example.android.slider

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_slider.*
import kotlinx.android.synthetic.main.activity_slider.indicator

class SliderShow : AppCompatActivity() {
    var currentPage: Int = 0
    var NUM_PAGES: Int = 5
    lateinit var viewModel: SliderShowViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)
        slidwershowViewPager.adapter=SliderViewPagerAdapter()
        indicator.setViewPager(slidwershowViewPager)
        viewModel = ViewModelProviders.of(this).get(SliderShowViewModel::class.java)
        viewModel.swipeViewPager()
        viewModel.viewPager!!.observe(this , android.arch.lifecycle.Observer{
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            slidwershowViewPager.setCurrentItem(currentPage++, true)

        })
        skip_text.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
        nextImage.setOnClickListener {

            viewModel.swipeViewPager()
        }
    }

}
