package com.simx.mvvm.ui.main.vm


import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.databinding.ObservableField
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.simx.mvvm.data.PintroMenuItem

class PintroMenuViewModel(pintroMenuItem: PintroMenuItem):ViewModel() {
    val name = ObservableField<String> (
            pintroMenuItem.name
    )
    val image = ObservableField<String> (
            pintroMenuItem.icon
    )
    companion object {
        @BindingAdapter("bind:imageUrl")
        @JvmStatic
        fun loadImage(imageView: ImageView, url:String){
            Glide.with(imageView.context).load(url).into(imageView)
        }
    }

}