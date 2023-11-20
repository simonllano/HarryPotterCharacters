package com.simonllano.harrypottercharacters.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HarryPotterCharacter {

    private const val urlApi = "https://hp-api.onrender.com/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()


 val retrofit: ApiService = Retrofit.Builder()
     .baseUrl(urlApi)
     .addConverterFactory(GsonConverterFactory.create())
     .client(okHttpClient)
     .build()
  .run{
       create(ApiService:: class.java)
  }

}