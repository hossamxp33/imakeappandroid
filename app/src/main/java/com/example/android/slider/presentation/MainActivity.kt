package com.example.android.slider.presentation
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.databinding.DataBindingUtil
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.example.android.slider.*
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.ui.splash.SplashUi
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import com.example.android.slider.databinding.ActivityMainBinding
import com.example.android.slider.presentation.buyfragment.BuyFragment
import com.example.android.slider.presentation.homefragment.HomeFragment
import com.example.android.slider.presentation.moreframgent.MoreFragment


class MainActivity : AppCompatActivity(),Serializable {

    var settings_data: SettingsUseCase? = null
    lateinit var viewModel: UserViewModel
    lateinit var homeFragment: HomeFragment
    lateinit var moreFragment: MoreFragment
    lateinit var buyFragment: BuyFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val intent: Intent? = getIntent()
        settings_data = intent?.getSerializableExtra(SplashUi.SETTINGUSECASEkEY) as SettingsUseCase

          val  homeFragment = HomeFragment()
            val bundle = Bundle()
            bundle.putSerializable("data", settings_data  as Serializable)
            homeFragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fragment, homeFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()


        buttomNavigationView.setOnNavigationItemSelectedListener (mOnNavigationItemSelectedListener)
        val url = settings_data!!.headerSettingUseCase!!.logo
        Glide.with(this)
            .asBitmap()
            .load(url)
            .into(object : CustomTarget<Bitmap>() {
                override fun onLoadCleared(placeholder: Drawable?) {
                    TODO("not implemented")
                }
                override fun onResourceReady(resource: Bitmap, transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?)
                {
                    val profileImage = BitmapDrawable(resources, resource)
                    buttomNavigationView.getMenu().getItem(1).setIcon(profileImage);
                }
            })
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