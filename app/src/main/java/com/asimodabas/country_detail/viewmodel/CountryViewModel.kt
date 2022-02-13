package com.asimodabas.country_detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.asimodabas.country_detail.model.Country

class CountryViewModel : ViewModel() {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataRoom() {

        val country = Country("Turkey", "Asia", "Turkish", "www.url.com", "TRY", "Ankara")
        countryLiveData.value = country
    }

}