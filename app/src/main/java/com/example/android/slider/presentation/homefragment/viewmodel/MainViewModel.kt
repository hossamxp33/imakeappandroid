package com.example.android.slider.presentation.homefragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.slider.datalayer.Repo.DataRepo
import com.example.android.slider.datalayer.usecases.MainDataUseCase
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.datalayer.usecases.SliderUseCase

class MainViewModel: ViewModel(){
    var MainReporository: DataRepo = DataRepo()
    var MainDataResponseLD : MutableLiveData<MainDataUseCase>? = null

    var errormessage: MutableLiveData<String>?= null
    init {
        MainDataResponseLD  = MutableLiveData()
        errormessage= MutableLiveData()
    }
    fun GetMainPageData(){
        MainReporository.GetMainPageData(MainDataResponseLD,errormessage)
    }

}