package com.example.android.slider.ui.slidershow

import android.content.Context
import androidx.databinding.DataBindingUtil
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.android.slider.R
import com.example.android.slider.datalayer.usecases.SliderShowUseCase
import com.example.android.slider.datalayer.usecases.SplashUsecase
import com.example.android.slider.models.slideshow.SlidersModelData
import com.squareup.picasso.Picasso

class SliderViewPagerAdapter(val context: Context ,val showModel: List<SplashUsecase>?):
    PagerAdapter(){

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater: LayoutInflater =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
        val view:View=layoutInflater.inflate(R.layout.viewpagerimage,container,false)
        val imageView: ImageView =view.findViewById(R.id.image_slider)
        val url=showModel?.get(position)?.photo
        //Glide.with(imageView.context).load(url).into(imageView)
        Picasso.get().load(url).into(imageView)
        container.addView(view)
        return view
    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun getCount(): Int {
        return showModel!!.size
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)

    }
}