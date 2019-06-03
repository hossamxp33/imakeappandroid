package com.example.android.slider


import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide


@BindingAdapter("app:imageResource")
fun setImageResource(imageView: ImageView, resource: String) {
    Glide.with(imageView.context).load(resource).into(imageView)

}
 class UserViewModel:ViewModel() {
val URL = "http://imakeapp.codesroots.com/assets/images/logo.png"
}
