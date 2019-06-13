package com.example.android.slider

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SliderViewPagerAdapter (val context: Context):PagerAdapter(){

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

            val layoutInflater: LayoutInflater =
                (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater)
            val view:View=layoutInflater.inflate(R.layout.slidershow_image,container,false)

        container.addView(view)

        return view
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