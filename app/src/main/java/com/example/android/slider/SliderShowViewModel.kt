package com.example.android.slider

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.os.Handler
import com.bumptech.glide.Glide
import android.widget.ImageView
import java.util.*

class SliderShowViewModel():ViewModel(){
    var viewPager: MutableLiveData<Int>?=null
    init {
        viewPager= MutableLiveData()

    }
    fun swipeViewPager() {
        val handler = Handler()
        val update = Runnable() {
            viewPager?.postValue(0)

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