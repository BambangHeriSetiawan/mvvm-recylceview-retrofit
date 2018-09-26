package com.simx.mvvm.data

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import java.util.concurrent.TimeUnit

interface API {
    @Headers("Accept: application/json", "Content-type: application/json")
    @GET("pintro/menu_edu.json")
    fun getMenuEdu(): Observable<ResponseMenu>

    object Factory{
        val retrofit: Retrofit? = null
        /**
         * Config GSON
         * @return
         */
        val gson: Gson
            get() {
                val gsonBuilder = GsonBuilder()
                gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                return gsonBuilder.create()
            }

        fun create(base_url: String): API {
            return getRetrofitConfig(base_url).create(API::class.java)
        }

        /**
         * Config retrofilt
         * @return
         */
        fun getRetrofitConfig(base_url: String): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client())
                    .build()
        }

        /**
         * Config OkhttpClient and interceptions
         * @return
         */
        private fun client(): OkHttpClient {
            return OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                    .build()
        }

    }

}