package com.example.android.slider.models.settings

import java.io.Serializable


data class SettingsModel(
    val data: List<SettingsModelData>
):Serializable

data class SettingsModelData (
    val type: String,
    val data: SettingData
):Serializable

data class SettingData (
    val background: String? = null,
    val red: String? = null,
    val green: String? = null,
    val blue: String? = null,
    val logo: String? = null,
    val rightIcon: String? = null,
    val leftIcon: String? = null,
    val border: String? = null,
    val shadow: String? = null,
    val firstIcon: String? = null,
    val firstLabel: String? = null,
    val secondIcon: String? = null,
    val secondLabel: String? = null,
    val thirdIcon: String? = null,
    val thirdLabel: String? = null,
    val forthIcon: String? = null,
    val forthLabel: String? = null,
    val fontColor: String? = null,
    val fontRed: String? = null,
    val fontGreen: String? = null,
    val fontBlue: String? = null,
    val title: String? = null,
    val fontcolor: String? = null,
    val fontfamily: String? = null,
    val slideshow: String? = null
):Serializable