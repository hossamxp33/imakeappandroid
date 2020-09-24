package com.example.android.slider.datalayer.usecases

import com.example.android.slider.models.maindatamodel.*
import java.io.Serializable


data class MainDataUseCase(val mainData: MainDataModel?=null): Serializable {
    var Slider: List<SliderUseCase>? = null
    var Category: List<CategoryUseCase>? = null
    var FamousProduct: List<FamousProductUseCase>? = null
    var RatingBar: List<RatingProductUseCase>? = null


    init {
        Slider = ConvertSliderTOSliderViewModel(mainData!!.sliders)
        Category = ConvertCategoryTOCategoryViewModel(mainData.category)
        FamousProduct = convertFamousToFamousViewModel(mainData.randproduct)
        RatingBar = convertRatingToRatingViewModel(mainData.randproduct.get(0).total_rating)
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

fun  convertRatingToRatingViewModel(ratingproduct: List<Total_rating>?):List<RatingProductUseCase>{
    return ratingproduct!!.map { RatingProductUseCase(it) }
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
data class RatingProductUseCase(val ratingproduct: Total_rating? = null) : Serializable {

    var stars : Int? = null
    var product_id : Int? = null


    init {
        stars = ratingproduct!!.stars
        product_id = ratingproduct!!.product_id

    }

}