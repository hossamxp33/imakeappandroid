package com.example.android.slider.ui.slidershow

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Handler
import com.example.android.slider.datalayer.Repo.SplashRepo
import com.example.android.slider.datalayer.usecases.SliderShowUseCase
import com.example.android.slider.datalayer.usecases.SplashUsecase
import java.util.*

class SliderShowViewModel():ViewModel(){

    var viewPager: MutableLiveData<Int>?=null
    var splashReporository: SplashRepo = SplashRepo()
    var slideResponse : MutableLiveData<List<SliderShowUseCase>>? = null
    var errormessage: MutableLiveData<String>?= null
    init {
        viewPager= MutableLiveData()
        slideResponse= MutableLiveData()
        errormessage= MutableLiveData()

    }


}