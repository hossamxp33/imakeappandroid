package com.example.android.slider.ui.splash

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Handler
import android.support.v4.util.Consumer
import com.example.android.slider.datalayer.Repo.SplashRepo
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.datalayer.usecases.SplashUsecase
import java.util.*


class SplashViewModel:ViewModel() {
    var viewPager: MutableLiveData<Int>?=null
    var splashReporository: SplashRepo = SplashRepo()
    var clientsResponseLD : MutableLiveData<List<SplashUsecase>>? = null
    var errormessage: MutableLiveData<String>?= null
        init {
        clientsResponseLD = MutableLiveData()
         errormessage= MutableLiveData()
         viewPager=MutableLiveData()
    }
    fun getData(){

        splashReporository.getSplashData(clientsResponseLD,errormessage)

    }

   /* fun getSlide(){
        splashReporository.getSliderShow(slideResponse,errormessage)
    }*/
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