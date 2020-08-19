package com.example.android.slider.presentation.homefragment

import androidx.databinding.DataBindingUtil
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.slider.R
import com.example.android.slider.databinding.SliderTamplet1Binding
import com.example.android.slider.databinding.SliderTamplet2Binding
import com.example.android.slider.databinding.ViewpagerimageBinding
import com.example.android.slider.datalayer.usecases.SettingsUseCase


class ViewPagerAdapter(setting:  SettingsUseCase): PagerAdapter() {
  //  private val slidersData: List<SettingData>? = sliders
  private val slidersData:  SettingsUseCase = setting

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        when (slidersData.slider_template) {
            "1" ->{
                val binding:ViewpagerimageBinding=DataBindingUtil.inflate(
                    LayoutInflater.from(container.context),
                    R.layout.viewpagerimage,
                    container, false)
                    container.addView(binding.root)
                    return binding.root}

            "2" -> {
                val binding: SliderTamplet1Binding =DataBindingUtil.inflate(
                    LayoutInflater.from(container.context),
                    R.layout.slider_tamplet_1,
                    container, false)
                    container.addView(binding.root)
                    return binding.root}
            "3" -> {
                val binding: SliderTamplet2Binding =DataBindingUtil.inflate(
                    LayoutInflater.from(container.context),
                    R.layout.slider_tamplet_2,
                    container, false)
                    container.addView(binding.root)
                    return binding.root}

        }


    return true
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun getCount(): Int {
        return 5
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)

    }


}