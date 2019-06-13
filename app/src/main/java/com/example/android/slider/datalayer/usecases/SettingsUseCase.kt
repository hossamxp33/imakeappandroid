package com.example.android.slider.datalayer.usecases

import com.example.android.slider.models.splash.SettingData
import com.example.android.slider.models.splash.SettingsModel
import com.example.android.slider.models.splash.SettingsModelData


data class SettingsUseCase(val settings: SettingsModel?=null){
    var type: String?=null
    var data: SettingsModel?=null
    init {

data = settings


    }
}