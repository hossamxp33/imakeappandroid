package com.example.android.slider.ui.splash

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.android.slider.MainActivity
import com.example.android.slider.R
import com.example.android.slider.UserViewModel
import com.example.android.slider.databinding.SplashLayoutBinding
import kotlinx.android.synthetic.main.splash_layout.*

@SuppressLint("Registered")
class SplashUi:AppCompatActivity(){
    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000 //3 seconds
    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {

            val intent = Intent(applicationContext,     MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    lateinit var viewModel: SplashViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  binding: SplashLayoutBinding = DataBindingUtil.setContentView(this,R.layout.splash_layout)
        //Initialize the Handler
        mDelayHandler = Handler()


        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
        viewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        viewModel.getData()
        viewModel.clientsResponseLD?.observe(this , android.arch.lifecycle.Observer {
        binding.splash = it!!.first()

        })
    }
        //Glide.with(imageView.context).load(viewModel.imageUrl).into(imageView)
        public override fun onDestroy() {

            if (mDelayHandler != null) {
                mDelayHandler!!.removeCallbacks(mRunnable)
            }

            super.onDestroy()
        }

}

