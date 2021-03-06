package com.example.android.slider.presentation.homefragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.Observer
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
import androidx.recyclerview.widget.RecyclerView
import com.example.android.slider.datalayer.usecases.*
import com.example.android.slider.presentation.homefragment.adapter.FamousProductAdapter

import androidx.core.content.ContextCompat
import android.graphics.drawable.ShapeDrawable
import android.os.Build
import android.text.Layout
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.drawable.DrawableCompat
import com.example.android.slider.R
import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer
import kotlinx.android.synthetic.main.productview.view.*


class HomeFragment: Fragment(){
    var currentPage: Int = 0
    var NUM_PAGES: Int = 3
    var indicator: CirclePageIndicator? = null
    var settigs_data:SettingsUseCase?=null
    val settings: SettingsModelData?=null
   lateinit var  sliders : Sliders
    var sliderUseCse: List<SliderUseCase> ? = null
    var categoryUseCse: List<CategoryUseCase> ? = null
    var famousUseCse: List<FamousProductUseCase> ? = null

    var settingUseCse: SettingsUseCase? = null
    var rate:  List<RatingProductUseCase> ? = null

    lateinit var settingsViewModel: SettingViewModel
    lateinit var mainViewModel : MainViewModel
    private var imslider: RoundedImageView? = null
    private var backimage = image_slider_background

    lateinit var viewModel: HomeViewModel
    @SuppressLint("UnsafeExperimentalUsageError", "ResourceType")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View=inflater.inflate(com.example.android.slider.R.layout.homefragment,container,false)

        settingsViewModel =ViewModelProviders.of(this).get(SettingViewModel::class.java)

        mainViewModel =ViewModelProviders.of(this).get(MainViewModel::class.java)
        mainViewModel.GetMainPageData()
        var SettingData =  arguments?.getSerializable("data") as SettingsUseCase ;
        imslider = image_slider
        indicator = indicator
        settingsViewModel.getSettings()

        mainViewModel.MainDataResponseLD?.observe(this, Observer {
            sliderUseCse = it.Slider // 1
            categoryUseCse = it.Category // 2
            famousUseCse = it.FamousProduct // 3
            rate = it.RatingBar

            settigs_data = SettingData
            settingUseCse = settigs_data!!

           //// Body_background
            val backcolor = settingUseCse!!.bodyDesignUseCase!!.background!!
            view.home_fragment_container.setBackground(backcolor)


            //// products_background
            val color = Color.YELLOW
            val unwrappedDrawable = AppCompatResources.getDrawable(context!!, R.drawable.round_border_product)
            val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
            DrawableCompat.setTint(wrappedDrawable, color  )

            view.viewpager?.adapter = ViewPagerAdapter(activity!!,settingUseCse!!,sliderUseCse)

            when  (settingUseCse!!.headerSettingUseCase!!.slider_template){
                "1" -> {
                    viewpager!!.clipChildren = false
                    viewpager!!.clipToPadding = false
                    val tabLayout = tabDots
                    tabLayout.setupWithViewPager(viewpager, true)
                }
                "2" -> {
                    viewpager!!.clipChildren = false
                    viewpager!!.clipToPadding = false
                    viewpager!!.pageMargin = 20
                    viewpager.offscreenPageLimit = 3
                    viewpager.setPadding(80,0,80,0)
                    val tabLayout = tabline2
                    tabLayout.setupWithViewPager(viewpager, true)
                    viewpager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
                }
                "3" -> {
                    viewpager!!.clipChildren = false
                    viewpager!!.clipToPadding = false
                    val tabLayout = tabDots
                    tabLayout.setupWithViewPager(viewpager, true)
                     // Create an object of page transformer
                    val cardFlipPageTransformer = CardFlipPageTransformer()
                    cardFlipPageTransformer.setScalable(false);
                    viewpager.setPageTransformer(true,cardFlipPageTransformer)

                }else -> { // Note the block
                print("x is neither 1 nor 2")
            }
            }
            when  (settingUseCse!!.categoryDesignUseCase!!.category_template){
                "0" -> {
                    view.recyclerView?.adapter= ProductViewAdapter(categoryUseCse!!,settingUseCse!!.categoryDesignUseCase!!)
                    view.recyclerView?.setLayoutManager(LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true))
                }
                "1" ->{
                    view.recyclerView?.adapter= ProductViewAdapter(categoryUseCse!!,settingUseCse!!.categoryDesignUseCase!!)
                    view.recyclerView?.setLayoutManager(LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true))
                }
                "2" ->{
                    view.recyclerView?.adapter= ProductViewAdapter(categoryUseCse!!,settingUseCse!!.categoryDesignUseCase!!)
                    view.recyclerView?.setLayoutManager(LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true))
                }
                "3" ->{
                    view.recyclerView?.adapter= ProductViewAdapter(categoryUseCse!!,settingUseCse!!.categoryDesignUseCase!!)
                    view.recyclerView.layoutManager = GridLayoutManager(context,2)
                }else -> {
                view.recyclerView?.adapter= ProductViewAdapter(categoryUseCse!!,settingUseCse!!.categoryDesignUseCase!!)
                view.recyclerView.layoutManager = GridLayoutManager(context,2)
            }


            }

            when (settingUseCse!!.productSettingUseCase!!.product_template){
                "0" -> {
                    view.product_recyclerView?.adapter= FamousProductAdapter(famousUseCse!!,settingUseCse!!,rate!!)
                    view.product_recyclerView.setLayoutManager(LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true))
                }
              "1" -> {
              view.product_recyclerView?.adapter= FamousProductAdapter(famousUseCse!!,settingUseCse!!,rate!!)
              view.product_recyclerView.setLayoutManager(GridLayoutManager(getContext(), 4))
                }
                "2" -> {
                    view.product_recyclerView?.adapter= FamousProductAdapter(famousUseCse!!,settingUseCse!!,rate!!)
                    view.product_recyclerView.setLayoutManager(GridLayoutManager(getContext(), 2))
                }else -> {
                view.product_recyclerView?.adapter= FamousProductAdapter(famousUseCse!!,settingUseCse!!,rate!!)
                view.product_recyclerView.setLayoutManager(GridLayoutManager(getContext(), 2))
            }
            }


        })




        viewModel= ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.swipeViewPager()
        viewModel.viewPager?.observe(this , androidx.lifecycle.Observer{
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            viewpager.setCurrentItem(currentPage++, true)

        })

        return view

    }


}
