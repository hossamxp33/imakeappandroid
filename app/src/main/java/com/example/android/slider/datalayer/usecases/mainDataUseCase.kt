package com.example.android.slider.datalayer.usecases

import com.example.android.slider.models.maindatamodel.Category
import com.example.android.slider.models.maindatamodel.MainDataModel
import com.example.android.slider.models.maindatamodel.Sliders
import com.example.android.slider.models.maindatamodel.product
import java.io.Serializable


data class MainDataUseCase(val mainData: MainDataModel?=null): Serializable {
    var Slider: List<SliderUseCase>? = null
    var Category: List<CategoryUseCase>? = null
    var FamousProduct: List<FamousProductUseCase>? = null


    init {
        Slider = ConvertSliderTOSliderViewModel(mainData!!.sliders)
        Category = ConvertCategoryTOCategoryViewModel(mainData.category)
        FamousProduct = convertFamousToFamousViewModel(mainData.randproduct)
    }
}

    fun ConvertSliderTOSliderViewModel(sliders: List<Sliders>): List<SliderUseCase> {
        return sliders.map { SliderUseCase(it) }
    }

    fun ConvertCategoryTOCategoryViewModel(category: List<Category>): List<CategoryUseCase> {
        return category.map { CategoryUseCase(it) }
    }
fun  convertFamousToFamousViewModel(famousproduct : List<product>):List<FamousProductUseCase>{
    return famousproduct.map { FamousProductUseCase(it) }
}


    data class SliderUseCase(val slider: Sliders? = null) : Serializable {
        var photo: String? = null
        init {
            photo = slider!!.photo
        }
    }

    data class CategoryUseCase(val category: Category? = null) : Serializable {
        var photo: String? = null

        init {
            photo = category!!.photo
        }

    }

data class FamousProductUseCase(val famousproduct: product? = null) : Serializable {
    var name: String? = null
    var price: Int? = null
    var photo: String? = null

    init {
        name = famousproduct!!.name
        price = famousproduct.price
        photo = famousproduct.img
    }

}