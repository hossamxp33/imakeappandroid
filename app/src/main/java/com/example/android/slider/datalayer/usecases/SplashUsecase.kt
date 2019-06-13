package com.example.android.slider.datalayer.usecases


import com.example.android.slider.models.splash.Splash_model


data class SplashUsecase(val data: Splash_model? = null){
    var id:Long?= null
    var photo :String?
    var created: String? = null
    var modified: String?


    init {

        id   =data?.id
        photo=data?.photo
        created=data?.created
        modified=data?.modified

    }


}

