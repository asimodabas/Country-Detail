package com.asimodabas.country_detail.util

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

class CustomSharedPreferences {

    companion object {
        private val PREFERINCES_TIME = "preferincestime"
        private var sharedPreferences: SharedPreferences? = null

        @Volatile
        private var instance: CustomSharedPreferences? = null

        private val lock = Any()
        operator fun invoke(context: Context): CustomSharedPreferences =
            instance ?: synchronized(lock) {
                instance ?: makeCustomSharedPreferences(context).also {
                    instance = it
                }
            }

        private fun makeCustomSharedPreferences(context: Context): CustomSharedPreferences {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return CustomSharedPreferences()
        }
    }

    fun saveTime(time: Long) {
        sharedPreferences?.edit(commit = true) {
            putLong(PREFERINCES_TIME, time)
        }
    }

    fun getTime() = sharedPreferences?.getLong(PREFERINCES_TIME, 0)
}