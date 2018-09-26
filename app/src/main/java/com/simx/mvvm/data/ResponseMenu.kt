package com.simx.mvvm.data

import com.google.gson.annotations.SerializedName

data class ResponseMenu(
        @field:SerializedName("PintroMenu")
        val pintroMenu: List<PintroMenuItem> = listOf()
){
    override fun toString(): String {
        return "ResponseMenu(pintroMenu=$pintroMenu)"
    }
}

