package com.example.android.slider.ui.splash

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import com.example.android.slider.MainActivity
import com.example.android.slider.R
import com.example.android.slider.ui.slidershow.SliderShow
import com.example.android.slider.databinding.SplashLayoutBinding
import com.example.android.slider.datalayer.usecases.SettingsUseCase
import com.example.android.slider.models.settings.SettingsModelData
import com.example.android.slider.ui.settingviewmodel.SettingViewModel
import java.io.Serializable
import kotlin.collections.forEach as forEach1

@SuppressLint("Registered")
class SplashUi() :AppCompatActivity()
{
companion object{
    val SETTINGUSECASEkEY:String = "Settings"
}
  var settigs_data:List<SettingsUseCase>?=null
   val settings: SettingsModelData?=null
    var settingUseCse: SettingsUseCase = SettingsUseCase(settings)
    lateinit var settingsViewModel: SettingViewModel
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 5000 //3 seconds
    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
                    val intent = Intent(this, SliderShow::class.java)
            startActivity(intent)
                    finish()

            }

    }

    lateinit var splashViewModel: SplashViewModel
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  binding: SplashLayoutBinding = DataBindingUtil.setContentView(this,R.layout.splash_layout)
        //Initialize the Handler
        mDelayHandler = Handler()


        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        settingsViewModel=ViewModelProviders.of(this).get(SettingViewModel::class.java)
        splashViewModel.getData()
        splashViewModel.clientsResponseLD?.observe(this , android.arch.lifecycle.Observer {
        binding.splash = it!!.get(0)


        })

        settingsViewModel.getSettings()
        settingsViewModel.settingsResponse?.observe(this , android.arch.lifecycle.Observer {
            settingUseCse= it!!.get(0)
          settigs_data=it
           val bundle=Bundle()
            val data_Intent = Intent(this, MainActivity::class.java)
           data_Intent.putExtra(SETTINGUSECASEkEY, settigs_data as Serializable)
            data_Intent.putExtras(bundle)
            startActivity(data_Intent)
            finish()
            mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
            it.forEach {
              //  println(it)
              //  println(it.settings!!.data.background)
            }
        })

    }

    override fun onDestroy() {

            if (mDelayHandler != null) {
                mDelayHandler!!.removeCallbacks(mRunnable)
            }

            super.onDestroy()
        }

}





