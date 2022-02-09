package com.asimodabas.country_detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asimodabas.country_detail.model.Country

class FeedViewModel : ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()


    fun refreshData() {

        //Try Countries
        val country = Country("Turkey", "Asia", "Turkish", "www.url.com", "TRY", "Ankara")
        val country2 = Country("aaa", "bbb", "ccc", "www.url.com", "eee", "fff")

        val countryList = arrayListOf<Country>(country, country2)

        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }


}