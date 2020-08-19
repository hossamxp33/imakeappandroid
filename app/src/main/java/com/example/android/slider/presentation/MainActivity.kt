package com.example.android.slider.presentation
import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import com.example.android.slider.*
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.ui.splash.SplashUi
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

import com.example.android.slider.databinding.ActivityMainBinding
import com.example.android.slider.presentation.buyfragment.BuyFragment
import com.example.android.slider.presentation.homefragment.HomeFragment
import com.example.android.slider.presentation.moreframgent.MoreFragment
import com.example.android.slider.presentation.offerfragment.OffersFragment


class MainActivity : AppCompatActivity(),Serializable {

    var settings_data: List<SettingsUseCase>? = null
    lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       buttomNavigationView.setOnNavigationItemSelectedListener ( listener)
        buttomNavigationView.setSelectedItemId(R.id.nav_home)

        val intent: Intent? = getIntent()
       settings_data = intent?.getSerializableExtra(SplashUi.SETTINGUSECASEkEY) as List<SettingsUseCase>
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        binding.settingusecase = settings_data
        binding.executePendingBindings()

    }
    //add navigation button
    private val listener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            var selectFragment: Fragment? = null
            when (menuItem.itemId) {
                R.id.nav_home -> selectFragment =
                    HomeFragment()
                R.id.nav_buy -> selectFragment =
                    BuyFragment()
                R.id.nav_more -> selectFragment =
                    MoreFragment()
                R.id.nav_offers ->selectFragment=
                    OffersFragment()
            }
            assert(selectFragment != null)
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment,
                selectFragment!!
            ).commit()
            true
        }
}