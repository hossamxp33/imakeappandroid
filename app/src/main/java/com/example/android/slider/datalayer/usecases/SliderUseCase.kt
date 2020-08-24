package com.example.android.slider.datalayer.usecases

import com.example.android.slider.models.maindatamodel.MainDataModel
import com.example.android.slider.models.maindatamodel.Sliders
import com.example.android.slider.models.settings.SettingsModelData
import java.io.Serializable


data class MainDataUseCase(val mainData: MainDataModel?=null): Serializable {
    var Slider:  List<SliderUseCase>?=null
    var photo: String? = null
    init {
        Slider = ConvertSliderTOSliderViewModel(mainData!!.sliders)
    }

fun ConvertSliderTOSliderViewModel(sliders: List<Sliders>): List<SliderUseCase> {

    return  sliders.map { SliderUseCase(it)

    }
    }
}

data class SliderUseCase(val slider: Sliders?=null): Serializable {
    var photo: String? = null
    init {
            photo=slider!!.photo
    }


}