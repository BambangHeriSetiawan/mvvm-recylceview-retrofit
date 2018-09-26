package com.simx.mvvm.ui.splash

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.simx.mvvm.R
import com.simx.mvvm.databinding.SplashActivityBinding
import com.simx.mvvm.ui.main.MainActivity
import com.simx.mvvm.ui.splash.vm.SplashViewModel

class SplashActivity : AppCompatActivity() {
   private fun gotoMain() {
        val main = Intent(this, MainActivity::class.java)
        startActivity(main)
        finish()
    }

    private lateinit var splashActivityBinding: SplashActivityBinding
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashActivityBinding = DataBindingUtil.setContentView(this, R.layout.splash_activity)
        splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        splashActivityBinding.splash = splashViewModel
        Handler().postDelayed({
            if (splashViewModel.checkApps())gotoMain()
        },2000)
    }

}
