package com.example.android.slider

import android.annotation.SuppressLint

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.constraint.ConstraintLayout
import android.support.v4.view.PagerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.android.slider.databinding.ViewpagerimageBinding





class ViewPagerAdapter(val context: Context):PagerAdapter() {


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding:ViewpagerimageBinding=DataBindingUtil.inflate(
            LayoutInflater.from(container.context),
            R.layout.viewpagerimage,
            container,
            false
        )

        container.addView(binding.root)
        return binding.root
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