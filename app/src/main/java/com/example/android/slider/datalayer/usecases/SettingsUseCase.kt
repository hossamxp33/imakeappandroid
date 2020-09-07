package com.example.android.slider.datalayer.usecases

import com.example.android.slider.models.settings.SettingsModel
import com.example.android.slider.models.settings.SettingsModelData
import java.io.Serializable

data class SettingsUseCase(val settings: SettingsModel?=null):Serializable {

    var settingData: List<SettingsModelData>? = null
    var headerSettingUseCase: HeaderSettingUseCase?=null
    var footerSettingUseCase: FooterSettingUseCase?=null
    var categoryDesignUseCase: CategoryDesignUseCase?=null
    var productSettingUseCase: ProductSettingUseCase?=null
    var bodyDesignUseCase: BodyDesignUseCase?=null


    //  var slideshow: String? = null

    init {

        settingData = settings!!.data
        for (data in settingData!!) {
            if (data.type == "header") {
                headerSettingUseCase =     HeaderSettingUseCase(data)
            } else
                if (data.type == "footer") {
                    footerSettingUseCase =    FooterSettingUseCase(data)
                } else
                    if (data.type == "categorydesign") {
                        categoryDesignUseCase =    CategoryDesignUseCase(data)
                    }
            if (data.type == "productsetting") {
                productSettingUseCase =  ProductSettingUseCase(data)
            } else
                if (data.type == "bodydesign") {
                    bodyDesignUseCase =  BodyDesignUseCase(data)
                }
        }
    }
}