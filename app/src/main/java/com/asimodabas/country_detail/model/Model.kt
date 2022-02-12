package com.asimodabas.country_detail.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val countryName: String?,
    @SerializedName("region")
    val countryRegion: String?,
    @SerializedName("language")
    val countryLanguage: String?,
    @SerializedName("flag")
    val imageUrl: String?,
    @SerializedName("currency")
    val countryCurrency: String?,
    @SerializedName("capital")
    val countryCapital: String?
)