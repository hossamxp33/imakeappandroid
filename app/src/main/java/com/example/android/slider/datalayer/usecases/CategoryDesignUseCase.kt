package com.example.android.slider.datalayer.usecases

import com.example.android.slider.models.settings.SettingsModelData
import java.io.Serializable


data class CategoryDesignUseCase(val settingData: SettingsModelData?=null): Serializable {



    var background: String? = "#fff"
    var red: String? = null
    var green: String? = null
    var blue: String? = null

    var border: String? = null
    var shadow: String? = null

    var fontColor: String? = null
    var fontRed: String? = null
    var fontGreen: String? = null
    var fontBlue: String? = null
    var title:String?=null
    var fontfamily: String? = null
    var category_template: String? = null

    init {

        title=settingData!!.data.title
        border=settingData!!.data.border
        shadow=settingData!!.data.shadow
        background=settingData!!.data.background
        red=settingData!!.data.red
        green=settingData!!.data.green
        blue=settingData!!.data.blue
        fontColor=settingData!!.data.fontColor
        fontRed=settingData!!.data.fontRed
        fontGreen=settingData!!.data.fontGreen
        fontBlue=settingData!!.data.fontBlue
        fontfamily=settingData!!.data.fontfamily
        category_template=settingData!!.data.category_template

    }

}