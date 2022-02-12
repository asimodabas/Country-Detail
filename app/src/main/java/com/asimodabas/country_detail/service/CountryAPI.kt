package com.asimodabas.country_detail.service

import com.asimodabas.country_detail.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {

    //https://raw.githubusercontent.com/asimodabas/Country-Detail/master/CountryData.json

    @GET("asimodabas/Country-Detail/master/CountryData.json")
    fun getCountry(): Single<List<Country>>


}