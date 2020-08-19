package com.example.android.slider.datalayer.usecases

import com.example.android.slider.models.settings.SettingsModelData
import java.io.Serializable

data class SettingsUseCase(val settings: SettingsModelData?=null):Serializable  {

    var settingData: SettingsModelData?=null
    var background: String? = "#fff"
    var red: String? = null
    var green: String? = null
    var blue: String? = null
    var logo: String? = null
    var rightIcon: String? = null
    var leftIcon: String? = null
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
    var title:String?=null
    var fontfamily: String? = null
    var slider_template: String? = null


    //  var slideshow: String? = null

    init {

settingData = settings
 if(settings?.type=="header"){
    background=settingData!!.data.background
    red=settingData!!.data.red
     green=settingData!!.data.green
     blue=settingData!!.data.blue
     logo=settingData!!.data.logo
     rightIcon=settingData!!.data.rightIcon
     leftIcon=settingData!!.data.leftIcon
     slider_template = "1"
 }else{}
if(settings?.type=="footer"){
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
}else{}

        if(settings?.type=="categorydesign"){
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
        }else{}
        if(settings?.type=="productsetting"){
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
        }else{}
        if (settings?.type=="bodydesign"){
            background=settingData!!.data.background
            red=settingData!!.data.red
            green=settingData!!.data.green
            blue=settingData!!.data.blue
        }else{}
    }


}