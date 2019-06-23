package com.example.android.slider.models.slideshow


data class SlideShowModel (
    val data: List<SlidersModelData>
)

data class SlidersModelData (
    val id: Long,
    val photo: String,
    val created: String,
    val modified: String
)