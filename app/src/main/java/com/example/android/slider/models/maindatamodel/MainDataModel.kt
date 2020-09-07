package com.example.android.slider.models.maindatamodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MainDataModel (

    @SerializedName("sliders")
    var sliders : List<Sliders>,
    @SerializedName("category")
    val category : List<Category>,
    @SerializedName("randproduct")
    val randproduct : List<product>
): Serializable


data class Sliders (
    @SerializedName("photo")
    val photo : String
):Serializable

data class Category (
    @SerializedName("id") val id : Int,
    @SerializedName("photo") val photo : String,
    @SerializedName("subcats") val subcats : List<Subcats>

):Serializable
data class Productphotos (

    @SerializedName("id") val id : Int,
    @SerializedName("photo") val photo : String,
    @SerializedName("main") val main : String,
    @SerializedName("product_id") val product_id : Int,
    @SerializedName("created") val created : String,
    @SerializedName("modified") val modified : String
):Serializable

data class Subcats (

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("category_id") val category_id : Int,
    @SerializedName("photo") val photo : String,
    @SerializedName("icon") val icon : String,
    @SerializedName("created") val created : String,
    @SerializedName("modified") val modified : String,
    @SerializedName("name_ar") val name_ar : String
):Serializable


data class Productsizes (

    @SerializedName("id") val id : Int,
    @SerializedName("product_id") val product_id : Int,
    @SerializedName("size") val size : Int,
    @SerializedName("price") val price : Int,
    @SerializedName("created") val created : String,
    @SerializedName("modified") val modified : String,
    @SerializedName("amount") val amount : Int
):Serializable

data class product (

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("subcat_id") val subcat_id : String,
    @SerializedName("category_id") val category_id : String,
    @SerializedName("price") val price : Int,
    @SerializedName("last_price") val last_price : Int,
    @SerializedName("description") val description : String,
    @SerializedName("store_id") val store_id : Int,
    @SerializedName("brand") val brand : String,
    @SerializedName("product_info") val product_info : String,
    @SerializedName("amount") val amount : Int,
    @SerializedName("guarantee") val guarantee : Int,
    @SerializedName("created") val created : String,
    @SerializedName("modified") val modified : String,
    @SerializedName("visible") val visible : Boolean,
    @SerializedName("name_ar") val name_ar : String,
    @SerializedName("description_ar") val description_ar : String,
    @SerializedName("total_rating") val total_rating : List<Total_rating>,
    @SerializedName("productphotos") val productphotos : List<Productphotos>,
    @SerializedName("productsizes") val productsizes : List<Productsizes>
):Serializable

data class Total_rating (

    @SerializedName("product_id") val product_id : Int,
    @SerializedName("stars") val stars : Int,
    @SerializedName("count") val count : Int
):Serializable
