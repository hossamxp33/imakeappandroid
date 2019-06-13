package com.example.android.slider.models.splash
data class SplashData (
    val data: List<Splash_model>
)

data class Splash_model(
    val id: Long,
    val photo: String,
    val created: String,
    val modified: String
)
