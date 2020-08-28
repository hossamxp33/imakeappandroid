package com.example.android.slider.datalayer.usecases

import android.content.Context
import androidx.databinding.BindingAdapter
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.transition.Transition
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.example.android.slider.models.slideshow.SlidersModelData
@BindingAdapter("app:imageResource")
fun setImageResource(imageView: ImageView?, resource: String?) {
    Glide.with(imageView?.context!!).load(resource).into(imageView)
}
@BindingAdapter("app:backgroundImageUrl")
fun loadBackgroundImage(view: ImageView, imageUrl:String?)
{
    Glide.with(view.context).load(imageUrl).into(object: SimpleTarget<Drawable>()
    {
        override fun onResourceReady(
            resource: Drawable,
            transition: com.bumptech.glide.request.transition.Transition<in Drawable>?)
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            {
                view.background = resource}

        }


    })
}

@BindingAdapter("imageUrl")
fun loadBackSliderImage(context: Context, imag: ImageView, url: String?) {
    Glide.with(context).applyDefaultRequestOptions(
        RequestOptions()
            .placeholder(com.example.android.slider.R.drawable.noimg)
            .error(com.example.android.slider.R.drawable.noimg)).load(url).override(5 , 5)
        .into(imag)

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
