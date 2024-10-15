package com.example.project01.reinoso1165606.networkingtest.services

import com.example.project01.reinoso1165606.networkingtest.model.RemoteResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface RetrofitService {

    @GET("v1/forecast?current=temperature_2m&hourly=temperature_2m&timezone=auto")
    suspend fun listWeather(
        @Query("latitude") latitude:Double,
        @Query("longitude") longitude:Double
        ): RemoteResult
}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }
}