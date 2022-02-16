package com.asimodabas.country_detail.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.asimodabas.country_detail.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/*
//Estension add
fun String.myExtension (myParameter:String){
    println(myParameter)}
*/

fun ImageView.downloadUrl(url: String?, progressDrawable: CircularProgressDrawable) {

    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

fun placeHolderProgesBar(context: Context): CircularProgressDrawable {

    return CircularProgressDrawable(context).apply {
        strokeWidth = 6f
        centerRadius = 35f
        start()
    }
}