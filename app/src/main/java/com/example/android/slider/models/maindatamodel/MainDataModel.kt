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
    val photo : String? = null
):Serializable

data class Category (
    @SerializedName("id") val id : Int? = null,
    @SerializedName("photo") val photo : String? = null,
    @SerializedName("subcats") val subcats : List<Subcats>

):Serializable
data class Productphotos (

    @SerializedName("id")
    val id : Int? = null,
    @SerializedName("photo") val photo : String? = null,
    @SerializedName("main") val main : String? = null,
    @SerializedName("product_id") val product_id : Int? = null,
    @SerializedName("created") val created : String? = null,
    @SerializedName("modified") val modified : String? = null
):Serializable

data class Subcats (

    @SerializedName("id") val id : Int? = null,
    @SerializedName("name") val name : String? = null,
    @SerializedName("category_id") val category_id : Int? = null,
    @SerializedName("photo") val photo : String? = null,
    @SerializedName("icon") val icon : String? = null,
    @SerializedName("created") val created : String? = null,
    @SerializedName("modified") val modified : String? = null,
    @SerializedName("name_ar") val name_ar : String? = null
):Serializable


data class Productsizes (

    @SerializedName("id") val id : Int? = null,
    @SerializedName("product_id") val product_id : Int? = null,
    @SerializedName("size") val size : Int? = null,
    @SerializedName("price") val price : Int? = null,
    @SerializedName("created") val created : String? = null,
    @SerializedName("modified") val modified : String? = null,
    @SerializedName("amount") val amount : Int? = null
):Serializable

data class product (

    @SerializedName("id") val id : Int? = null,
    @SerializedName("name") val name : String? = null,
    @SerializedName("subcat_id") val subcat_id : String? = null,
    @SerializedName("category_id") val category_id : String? = null,
    @SerializedName("price") val price : Int? = null,
    @SerializedName("last_price") val last_price : Int? = null,
    @SerializedName("description") val description : String? = null,
    @SerializedName("store_id") val store_id : Int? = null,
    @SerializedName("brand") val brand : String? = null,
    @SerializedName("product_info") val product_info : String? = null,
    @SerializedName("amount") val amount : Int? = null,
    @SerializedName("guarantee") val guarantee : Int? = null,
    @SerializedName("created") val created : String? = null,
    @SerializedName("modified") val modified : String? = null,
    @SerializedName("visible") val visible : Boolean? = null,
    @SerializedName("total_rating") val total_rating : List<Total_rating>? = null,
    @SerializedName("productphotos") val productphotos : List<Productphotos>? = null,
    @SerializedName("productsizes") val productsizes : List<Productsizes>? = null,
    @SerializedName("img") val img :String? = null

    ):Serializable

data class Total_rating (

    @SerializedName("product_id") val product_id : Int? = null,
    @SerializedName("stars") val stars : Int? = null,
    @SerializedName("count") val count : Int? = null
):Serializable
