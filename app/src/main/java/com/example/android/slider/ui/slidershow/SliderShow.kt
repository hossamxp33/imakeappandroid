package com.example.android.slider.ui.slidershow

import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.slider.presentation.MainActivity
import com.example.android.slider.R
import com.example.android.slider.datalayer.usecases.SplashUsecase
import com.example.android.slider.ui.splash.SplashViewModel
import kotlinx.android.synthetic.main.activity_slider.*
import kotlinx.android.synthetic.main.activity_slider.indicator


class SliderShow : AppCompatActivity() {

    var currentPage: Int = 0
    var NUM_PAGES: Int = 3
    lateinit var viewModel: SplashViewModel

    var slider:List<SplashUsecase>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider)
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)

        viewModel.getData()
        viewModel.clientsResponseLD?.observe(this, androidx.lifecycle.Observer {
           println(it)
            slider=it
            slidwershowViewPager.adapter= SliderViewPagerAdapter(this,slider)
            indicator.setViewPager(slidwershowViewPager)
        })
        viewModel.viewPager?.observe(this, androidx.lifecycle.Observer{
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            slidwershowViewPager.setCurrentItem(currentPage++, true)
        })

        skip_text.setOnClickListener {
            val send_intent = Intent(this, MainActivity::class.java)
            startActivity(send_intent)
              finish()
        }
        nextImage.setOnClickListener {

            viewModel.swipeViewPager()
        }


    }

}
