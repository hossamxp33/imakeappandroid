package com.example.android.slider.datalayer.usecases

import com.example.android.slider.models.settings.SettingsModelData
import java.io.Serializable

data class BodyDesignUseCase(val settingData: SettingsModelData?=null): Serializable {


    var background: String? = "#fff"
    var red: String? = null
    var green: String? = null
    var blue: String? = null

    init {
        background=settingData!!.data.background
        red=settingData.data.red
        green=settingData.data.green
        blue=settingData.data.blue
    }

}