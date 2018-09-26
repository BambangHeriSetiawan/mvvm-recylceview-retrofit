package com.simx.mvvm.ui.main.vm

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModel
import com.simx.mvvm.BuildConfig
import com.simx.mvvm.data.API
import com.simx.mvvm.data.ResponseMenu
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    @SuppressLint("CheckResult")
    fun gdataMenu(): Observable<ResponseMenu>? {
        return API.Factory.create(BuildConfig.BASE_URL_GITHUB).getMenuEdu().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}
