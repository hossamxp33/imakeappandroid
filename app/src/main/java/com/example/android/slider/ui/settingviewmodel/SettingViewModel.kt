package com.example.android.slider.ui.settingviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.slider.datalayer.Repo.DataRepo

import com.example.android.slider.datalayer.usecases.SettingsUseCase

class SettingViewModel:ViewModel(){
    var settingReporository: DataRepo = DataRepo()
    var settingsResponse: MutableLiveData<List<SettingsUseCase>>?=null
    var errormessage: MutableLiveData<String>?= null
    init {
        settingsResponse  = MutableLiveData()
        errormessage=MutableLiveData()
    }
    fun getSettings(){
        settingReporository.getSettings(settingsResponse,errormessage)
    }

}