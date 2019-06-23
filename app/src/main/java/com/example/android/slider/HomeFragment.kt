package com.example.android.slider

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.homefragment.*
import kotlinx.android.synthetic.main.homefragment.view.*


class HomeFragment:Fragment(){
    var currentPage: Int = 0
    var NUM_PAGES: Int = 3
    lateinit var viewModel:HomeViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val view:View=inflater.inflate(R.layout.homefragment,container,false)
        view.viewpager?.adapter=ViewPagerAdapter()
        viewModel= ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.swipeViewPager()
        viewModel.viewPager?.observe(this , android.arch.lifecycle.Observer{
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            viewpager.setCurrentItem(currentPage++, true)
        })
      view.recyclerView?.adapter=ProductViewAdapter()
       view.recyclerView?.setLayoutManager(LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,true))
         view.product_recyclerView?.adapter=FamousProductAdapter()
        view.product_recyclerView.setLayoutManager(GridLayoutManager(getContext(),2))
        return view

    }
}
