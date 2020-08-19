package com.example.android.slider.presentation.homefragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.os.Handler
import java.util.*

class HomeViewModel:ViewModel() {
    var viewPager: MutableLiveData<Int>?=null
    init {
        viewPager=MutableLiveData()
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