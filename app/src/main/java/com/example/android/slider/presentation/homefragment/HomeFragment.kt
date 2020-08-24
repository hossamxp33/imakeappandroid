package com.example.android.slider.presentation.homefragment

import android.animation.ObjectAnimator
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.android.slider.*
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.datalayer.usecases.SliderUseCase
import com.example.android.slider.models.maindatamodel.Sliders
import com.example.android.slider.models.settings.SettingsModelData
import com.example.android.slider.presentation.homefragment.adapter.ProductViewAdapter
import com.example.android.slider.presentation.homefragment.adapter.ViewPagerAdapter
import com.example.android.slider.presentation.homefragment.viewmodel.MainViewModel
import com.example.android.slider.ui.settingviewmodel.SettingViewModel
import com.makeramen.roundedimageview.RoundedImageView
import com.viewpagerindicator.CirclePageIndicator
import kotlinx.android.synthetic.main.homefragment.*
import kotlinx.android.synthetic.main.homefragment.view.*
import kotlinx.android.synthetic.main.viewpagerimage.*
import android.graphics.Bitmap
import android.view.ViewTreeObserver

import android.os.Build
import android.annotation.TargetApi
import android.graphics.Canvas
import android.graphics.Path
import android.renderscript.Allocation
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import android.widget.ImageView
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_slider.view.*


class HomeFragment: Fragment(){
    var currentPage: Int = 0
    var NUM_PAGES: Int = 3
    var indicator: CirclePageIndicator? = null
    var settigs_data:List<SettingsUseCase>?=null
    val settings: SettingsModelData?=null
   lateinit var  sliders : Sliders
    var sliderUseCse: List<SliderUseCase> ? = null

    var settingUseCse: SettingsUseCase = SettingsUseCase(settings)
    lateinit var settingsViewModel: SettingViewModel
    lateinit var mainViewModel : MainViewModel
    private var imslider: RoundedImageView? = null

    lateinit var viewModel: HomeViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View=inflater.inflate(R.layout.homefragment,container,false)

        settingsViewModel =ViewModelProviders.of(this).get(SettingViewModel::class.java)

        mainViewModel =ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.GetMainPageData()
        var SettingData =  arguments?.getSerializable("data") as List<SettingsUseCase> ;
       imslider = image_slider

        indicator = indicator

        settingsViewModel.getSettings()

        mainViewModel.SliderDataResponseLD?.observe(this, Observer {
         sliderUseCse = it.Slider
            view.viewpager?.adapter =
                ViewPagerAdapter(
                    activity!!,settingUseCse,sliderUseCse
               )


        })



        settingsViewModel.settingsResponse?.observe(this , androidx.lifecycle.Observer {
            settingUseCse = it!!.get(0)
            settigs_data = it

            when (settingUseCse.slider_template) {
                "1" -> {
                    viewpager!!.clipChildren = false
                    viewpager!!.clipToPadding = false
                    viewpager.setCurrentItem(currentPage++,true)

//

                    val tabLayout = tabDots
                    tabLayout.setupWithViewPager(viewpager, true)
                    tabLayout.isTabIndicatorFullWidth = false
                    tabLayout!!.setPadding(80, 0, 80, 0)

                }
                "2" -> {
                    viewpager!!.clipChildren = false
                    viewpager!!.clipToPadding = false
                    viewpager!!.pageMargin = 20
                    viewpager!!.setPadding(80, 0, 50, 0)
                    val tabLayout = tabline2
                    tabLayout.setupWithViewPager(viewpager, true)
                    tabLayout.isTabIndicatorFullWidth = false
                }
                else -> { // Note the block
                    print("x is neither 1 nor 2")
                }
            }
        })


        viewModel= ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.swipeViewPager()
        viewModel.viewPager?.observe(this , androidx.lifecycle.Observer{
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
        })

      view.recyclerView?.adapter= ProductViewAdapter()
      view.recyclerView?.setLayoutManager(LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true))

     view.product_recyclerView?.adapter= FamousProductAdapter()
         view.product_recyclerView.setLayoutManager(GridLayoutManager(getContext(), 4))


        return view

    }


}
