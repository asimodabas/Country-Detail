package com.asimodabas.country_detail.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.asimodabas.country_detail.model.Country
import com.asimodabas.country_detail.service.CountryDatabase
import com.asimodabas.country_detail.service.CountryServiceAPI
import com.asimodabas.country_detail.util.CustomSharedPreferences
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class FeedViewModel(application: Application) : BaseViewModel(application) {

    private val countryApiService = CountryServiceAPI()
    private val disposable = CompositeDisposable()
    private var customPreferinces = CustomSharedPreferences(getApplication())
    private val refreshTime = 5 * 60 * 1000 * 1000 * 1000L

    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()


    fun refreshData() {
        val updateTime = customPreferinces.getTime()
        if (updateTime != null && updateTime != 0L && System.nanoTime() - updateTime < refreshTime) {
            getDataSQLite()
        } else {
            getDataAPI()
        }
    }

    fun refreshAPI() {
        getDataAPI()
    }

    private fun getDataSQLite() {
        countryLoading.value = true
        launch {
            val countries = CountryDatabase(getApplication()).countryDao()
                .getAllCountries() // All data -> countries
            showCountry(countries)
        }
    }

    private fun getDataAPI() {
        countryLoading.value = true

        disposable.add(
            countryApiService.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Country>>() {
                    override fun onSuccess(t: List<Country>) {
                        storeInSQLite(t)
                    }

                    override fun onError(e: Throwable) {
                        countryLoading.value = false
                        countryError.value = true
                        e.printStackTrace()
                    }

                })
        )
    }

    private fun showCountry(countryList: List<Country>) {
        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }

    private fun storeInSQLite(list: List<Country>) {
        launch {
            val dao = CountryDatabase(getApplication()).countryDao()
            dao.deleteAllCountries()
            val listLong = dao.insertAll(*list.toTypedArray())
            var i = 0
            while (i < list.size) {
                list[i].uuid = listLong[i].toInt()
                i = i + 1
            }
            showCountry(list)
        }
        customPreferinces.saveTime(System.nanoTime())
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}