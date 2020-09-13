package com.example.android.slider.datalayer.usecases

import com.example.android.slider.models.settings.SettingsModelData
import java.io.Serializable

data class HeaderSettingUseCase(val settingData: SettingsModelData?=null): Serializable {


    var background: String? = "#fff"
    var red: String? = null
    var green: String? = null
    var blue: String? = null
    var logo: String? = null
    var rightIcon: String? = null
    var leftIcon: String? = null
    var slider_template: String? = null

    init {
        background= settingData!!.data.background
        red= settingData!!.data.red
        green=settingData!!.data.green
        blue=settingData!!.data.blue
        logo=settingData!!.data.logo
        rightIcon=settingData!!.data.rightIcon
        leftIcon=settingData!!.data.leftIcon
        slider_template = settingData!!.data.slider_template
    }

}