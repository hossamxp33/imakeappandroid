package com.example.android.slider.ui.splash

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.support.v4.util.Consumer
import com.example.android.slider.datalayer.Repo.SplashRepo
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.datalayer.usecases.SplashUsecase



class SplashViewModel:ViewModel() {
    var splashReporository: SplashRepo = SplashRepo()
    var usecase:SplashUsecase= SplashUsecase()
    private var clientsResponse: Consumer<List<SplashUsecase>>? = null
    var clientsResponseLD : MutableLiveData<List<SplashUsecase>>? = null
    var settingsResponse:MutableLiveData<SettingsUseCase>?=null
    var errormessage: MutableLiveData<String>?= null
        init {
        clientsResponseLD = MutableLiveData()
            settingsResponse  = MutableLiveData()
    }
    fun getData(){

            splashReporository.getSplashData(clientsResponseLD,errormessage)

    }
    fun getSettings(){
        splashReporository.getSettings(settingsResponse,errormessage)
    }
}