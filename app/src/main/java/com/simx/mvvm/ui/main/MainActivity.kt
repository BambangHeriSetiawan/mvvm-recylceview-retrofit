package com.simx.mvvm.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.simx.mvvm.R
import com.simx.mvvm.ui.main.fm.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

}
