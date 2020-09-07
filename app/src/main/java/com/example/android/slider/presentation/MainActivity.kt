package com.example.android.slider.presentation
import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.android.slider.*
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.ui.splash.SplashUi
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

import com.example.android.slider.databinding.ActivityMainBinding
import com.example.android.slider.models.settings.SettingsModelData
import com.example.android.slider.presentation.buyfragment.BuyFragment
import com.example.android.slider.presentation.homefragment.HomeFragment
import com.example.android.slider.presentation.moreframgent.MoreFragment
import com.example.android.slider.presentation.offerfragment.OffersFragment


class MainActivity : AppCompatActivity(),Serializable {

    var settings_data: List<SettingsUseCase>? = null
    lateinit var viewModel: UserViewModel
    lateinit var homeFragment: HomeFragment
    lateinit var moreFragment: MoreFragment
    lateinit var buyFragment: BuyFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val intent: Intent? = getIntent()
        settings_data = intent?.getSerializableExtra(SplashUi.SETTINGUSECASEkEY) as List<SettingsUseCase>

          val  homeFragment = HomeFragment()
            val bundle = Bundle()
            bundle.putSerializable("data", settings_data  as Serializable)
            homeFragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fragment, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()


        buttomNavigationView.setOnNavigationItemSelectedListener (mOnNavigationItemSelectedListener)

        binding.settingusecase = settings_data
        binding.executePendingBindings()

    }

    //add navigation button
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.nav_home -> {
                homeFragment = HomeFragment()
                val bundle = Bundle()
                bundle.putSerializable("data", settings_data  as Serializable)
                homeFragment.arguments = bundle
                supportFragmentManager.beginTransaction().replace(R.id.fragment, homeFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                return@OnNavigationItemSelectedListener false
            }
            R.id.nav_buy -> {

                buyFragment = BuyFragment()

                supportFragmentManager.beginTransaction().replace(R.id.fragment, buyFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_more -> {
                moreFragment = MoreFragment()
                supportFragmentManager.beginTransaction().replace(R.id.fragment, moreFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .commit()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

}