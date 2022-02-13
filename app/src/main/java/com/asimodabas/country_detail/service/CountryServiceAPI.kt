package com.asimodabas.country_detail.service

import com.asimodabas.country_detail.model.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountryServiceAPI {

    //https://raw.githubusercontent.com/asimodabas/Country-Detail/master/CountryData.json

    private val BASE_URL = "https://raw.githubusercontent.com/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CountryAPI::class.java)

    fun getData(): Single<List<Country>> {
        return api.getCountry()
    }
}