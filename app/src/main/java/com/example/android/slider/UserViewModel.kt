package com.example.android.slider


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.databinding.BindingAdapter
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.util.*

@BindingAdapter("app:imageResource")
fun setImageResource(imageView: ImageView?, resource: String?) {
 Glide.with(imageView?.context!!).load(resource).into(imageView)
}

 class UserViewModel:ViewModel() {
  var viewPager:MutableLiveData<Int>?=null
init {
 viewPager= MutableLiveData()

}



}
