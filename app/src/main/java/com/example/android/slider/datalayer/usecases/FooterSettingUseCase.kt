package com.example.android.slider.datalayer.usecases

import com.example.android.slider.models.settings.SettingsModelData
import java.io.Serializable

data class FooterSettingUseCase(val settingData: SettingsModelData?=null): Serializable {

    var background: String? = "#fff"
    var red: String? = null
    var green: String? = null
    var blue: String? = null
    var border: String? = null
    var shadow: String? = null
    var firstIcon: String? = null
    var firstLabel: String? = null
    var secondIcon: String? = null
    var secondLabel: String? = null
    var thirdIcon: String? = null
    var thirdLabel: String? = null
    var forthIcon: String? = null
    var forthLabel: String? = null
    var fontColor: String? = null
    var fontRed: String? = null
    var fontGreen: String? = null
    var fontBlue: String? = null


    init {

        border=settingData!!.data.border
        shadow=settingData!!.data.shadow
        background=settingData!!.data.background
        red=settingData!!.data.red
        green=settingData!!.data.green
        blue=settingData!!.data.blue
        firstIcon=settingData!!.data.firstIcon
        firstLabel=settingData!!.data.firstLabel
        secondIcon=settingData!!.data.secondIcon
        secondLabel=settingData!!.data.secondLabel
        thirdIcon=settingData!!.data.thirdIcon
        thirdLabel=settingData!!.data.thirdLabel
        forthIcon=settingData!!.data.forthIcon
        forthLabel=settingData!!.data.forthLabel
        fontColor=settingData!!.data.fontColor
        fontRed=settingData!!.data.fontRed
        fontGreen=settingData!!.data.fontGreen
        fontBlue=settingData!!.data.fontBlue
    }

}