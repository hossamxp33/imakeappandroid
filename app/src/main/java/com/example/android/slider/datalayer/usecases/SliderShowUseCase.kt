package com.example.android.slider.datalayer.usecases

import android.databinding.BindingAdapter
import android.graphics.Color
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.android.slider.models.slideshow.SlidersModelData
@BindingAdapter("app:imageResource")
fun setImageResource(imageView: ImageView?, resource: String?) {
    Glide.with(imageView?.context!!).load(resource).into(imageView)
}
@BindingAdapter("android:backgroundColor")
fun ViewGroup.setBackground(backgroundColor: String) {

    val color: Int = try {
        Color.parseColor(backgroundColor)
    } catch (e: Exception) {
        Color.parseColor("#$background")
    }
    setBackgroundColor(color)
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
