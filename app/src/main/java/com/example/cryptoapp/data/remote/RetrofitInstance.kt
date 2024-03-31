package com.example.cryptoapp.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        val client = OkHttpClient.Builder().build()
        Retrofit.Builder().
        baseUrl(ApiValues.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()).client(client).build()
    }
    val cryptoApi by lazy {
        retrofit.create(CryptoApi::class.java)
    }
}