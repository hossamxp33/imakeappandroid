package com.example.android.slider.presentation.homefragment

import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.android.slider.*
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.models.settings.SettingsModelData
import com.example.android.slider.ui.settingviewmodel.SettingViewModel
import com.google.android.material.tabs.TabLayout
import com.viewpagerindicator.CirclePageIndicator
import kotlinx.android.synthetic.main.homefragment.*
import kotlinx.android.synthetic.main.homefragment.view.*


class HomeFragment: Fragment(){
    var currentPage: Int = 0
    var NUM_PAGES: Int = 3
    private var settings_data:  List<SettingsUseCase>? = null
    var indicator: CirclePageIndicator? = null
    var tab: Drawable? = null

    companion object{
        val SETTINGUSECASEkEY:String = "Settings"
    }
    var settigs_data:List<SettingsUseCase>?=null
    val settings: SettingsModelData?=null
    var settingUseCse: SettingsUseCase = SettingsUseCase(settings)
    lateinit var settingsViewModel: SettingViewModel

    lateinit var viewModel: HomeViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view:View=inflater.inflate(R.layout.homefragment,container,false)

        settingsViewModel=ViewModelProviders.of(this).get(SettingViewModel::class.java)
        indicator = indicator

        settingsViewModel.getSettings()
        settingsViewModel.settingsResponse?.observe(this , androidx.lifecycle.Observer {
            settingUseCse = it!!.get(0)
            settigs_data = it
            view.viewpager?.adapter =
                ViewPagerAdapter(settingUseCse)
            when (settingUseCse.slider_template) {
                "1" -> {
                    viewpager!!.clipChildren = false
                    viewpager!!.clipToPadding = false
                    val tabLayout = tabDots
                    tabLayout.setupWithViewPager(viewpager, true)
                    tabLayout.isTabIndicatorFullWidth = false
                    tabLayout!!.setPadding(80, 0, 80, 0)

                }
                "2" -> {
                    viewpager!!.pageMargin = 20

                    viewpager!!.setPadding(80, 0, 50, 0)
                    val tabLayout = tabline2
                    tabLayout.setupWithViewPager(viewpager, true)
                    tabLayout.isTabIndicatorFullWidth = false
                    tabLayout!!.setPadding(80, 0, 80, 0)



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
            viewpager.setCurrentItem(currentPage++, true)
        })
        view.recyclerView?.adapter=
            ProductViewAdapter()
        view.recyclerView?.setLayoutManager(
            LinearLayoutManager(
                getContext(),
                LinearLayoutManager.HORIZONTAL,
                true
            )
        )
        view.product_recyclerView?.adapter=
            FamousProductAdapter()
        view.product_recyclerView.setLayoutManager(
            GridLayoutManager(
                getContext(),
                2
            )
        )
        return view

    }
}
