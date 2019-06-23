package com.example.android.slider.datalayer.usecases

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.android.slider.models.slideshow.SlidersModelData
@BindingAdapter("app:imageResource")
fun setImageResource(imageView: ImageView?, resource: String?) {
    Glide.with(imageView?.context!!).load(resource).into(imageView)
}
data class SliderShowUseCase(val sliderData:SlidersModelData) {
    var id: Long?=null
    var photo: String?=null
    var created: String?=null
    var modified: String?=null

    init {
        id=sliderData.id
        photo=sliderData.photo
        created=sliderData.created
        modified=sliderData.modified
    }
}
