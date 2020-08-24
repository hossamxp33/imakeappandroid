package com.example.android.slider.presentation

import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.google.android.material.snackbar.Snackbar
import java.math.RoundingMode
import android.os.Build
import android.graphics.drawable.Drawable
import android.widget.LinearLayout
import androidx.databinding.BindingAdapter




fun Any.toast(context: Context, s: String) {
    Toast.makeText(context, this.toString(), Toast.LENGTH_LONG).show()
}

fun Any.snack(view: View, length: Int= Snackbar.LENGTH_SHORT ) {

    Snackbar.make(view ,this.toString(),length ).show()

}
fun Double.round() :Double{
   return this.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
}




fun Int.length() = when(this) {
    0 -> 1
    else -> Math.log10(Math.abs(toDouble())).toInt() + 1
}

@BindingAdapter("imageUrl")
fun loudImage(context: Context, imag: ImageView, url: String?) {
    Glide.with(context).applyDefaultRequestOptions(
        RequestOptions()
            .placeholder(com.example.android.slider.R.drawable.noimg)
            .error(com.example.android.slider.R.drawable.noimg))
        .load(url).into(imag)
}













