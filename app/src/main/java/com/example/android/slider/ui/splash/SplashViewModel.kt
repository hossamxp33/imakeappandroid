package com.example.android.slider.ui.splash

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.support.v4.util.Consumer
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.android.slider.datalayer.Repo.SplashRepo
import com.example.android.slider.datalayer.usecases.SplashUsecase

@BindingAdapter("app:imageResource")
fun setImageResource(imageView: ImageView?, resource: String?) {
    Glide.with(imageView?.context!!).load("http://imakeapp.codesroots.com/assets/images/logo.png").into(imageView)
}
class SplashViewModel:ViewModel() {
    var clientsRepository: SplashRepo = SplashRepo()
    var usecase:SplashUsecase= SplashUsecase()
    private var clientsResponse: Consumer<List<SplashUsecase>>? = null
    var clientsResponseLD : MutableLiveData<List<SplashUsecase>>? = null
    init {
        clientsResponseLD = MutableLiveData()
    }
    fun getData(){
        clientsRepository.getSplashData(clientsResponseLD)
    }
}