package com.asimodabas.country_detail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.asimodabas.country_detail.R
import com.asimodabas.country_detail.databinding.ItemCountryBinding
import com.asimodabas.country_detail.model.Country
import com.asimodabas.country_detail.util.downloadUrl
import com.asimodabas.country_detail.util.placeHolderProgesBar
import com.asimodabas.country_detail.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(val countryList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val infilater = LayoutInflater.from(parent.context)
      //val view = infilater.inflate(R.layout.item_country, parent, false)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(infilater,R.layout.item_country,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.country = countryList[position]

        /*

        holder.view.name.text = countryList[position].countryName
        holder.view.region.text = countryList[position].countryRegion

        holder.view.setOnClickListener {
            val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            action.countryUuid = countryList[position].uuid
            Navigation.findNavController(it).navigate(action)
        }
        holder.view.imageView.downloadUrl(
            countryList[position].imageUrl,
            placeHolderProgesBar(holder.view.context))

        */
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    //For Swipe Refresh
    fun updateCountryList(newCountryList: List<Country>) {
        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()
    }

}