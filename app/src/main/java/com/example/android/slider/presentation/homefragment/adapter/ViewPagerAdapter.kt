package com.example.android.slider.presentation.homefragment.adapter

import android.annotation.SuppressLint
import android.content.Context
import androidx.databinding.DataBindingUtil
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DimenRes
import androidx.annotation.Dimension
import androidx.fragment.app.FragmentActivity
import com.example.android.slider.R
import com.example.android.slider.databinding.SliderTamplet1Binding
import com.example.android.slider.databinding.SliderTamplet2Binding
import com.example.android.slider.databinding.ViewpagerimageBinding
import com.example.android.slider.datalayer.usecases.MainDataUseCase
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.datalayer.usecases.SliderUseCase
import com.example.android.slider.datalayer.usecases.loadBackSliderImage
import com.example.android.slider.presentation.loudImage
import com.google.android.material.imageview.ExperimentalImageView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily


class ViewPagerAdapter(
    activity: FragmentActivity, setting:  SettingsUseCase, sliderdata: List<SliderUseCase>?
): PagerAdapter() {
  //  private val slidersData: List<SettingData>? = sliders
    private val settingData:  SettingsUseCase = setting
    private val sliderdata:  List<SliderUseCase>? = sliderdata

    private val context: Context

    init {
        this.context = activity
    }
    @SuppressLint("UnsafeExperimentalUsageError")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        when (settingData.headerSettingUseCase!!.slider_template) {
            "1" ->{
                val binding:ViewpagerimageBinding=DataBindingUtil.inflate(
                    LayoutInflater.from(container.context),
                    R.layout.viewpagerimage,
                    container, false)
                loudImage(context,binding.imageSlider, sliderdata?.get(position)?.photo)
                loadBackSliderImage(context,binding.imageSliderBackground, sliderdata?.get(position)?.photo)
                    container.addView(binding.root)
                   binding.settingusecase = settingData
                   binding.sliderusecase = sliderdata!!.get(position)

                return binding.root}

            "2" -> {
                val binding: SliderTamplet1Binding =DataBindingUtil.inflate(
                    LayoutInflater.from(container.context),
                    R.layout.slider_tamplet_1,
                    container, false)
                     loudImage(context,binding.imageSlider, sliderdata?.get(position)?.photo)

                    container.addView(binding.root)
                    return binding.root}
            "3" -> {
                val binding: SliderTamplet2Binding =DataBindingUtil.inflate(
                    LayoutInflater.from(container.context),
                    R.layout.slider_tamplet_2,
                    container, false)
                loudImage(context,binding.imageSlider, sliderdata?.get(position)?.photo)

                container.addView(binding.root)
                    return binding.root}

        }


    return true
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`

    }

    override fun getCount(): Int {
        return sliderdata!!.size
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)

    }


}