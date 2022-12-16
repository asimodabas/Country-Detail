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
import com.asimodabas.country_detail.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country.view.country_uuid_Text

class CountryAdapter(val countryList: ArrayList<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(), CountryClickListener {

    class CountryViewHolder(var view: ItemCountryBinding) : RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val infilater = LayoutInflater.from(parent.context)
        //val view = infilater.inflate(R.layout.item_country, parent, false)
        val view = DataBindingUtil.inflate<ItemCountryBinding>(
            infilater, R.layout.item_country, parent, false
        )
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.view.country = countryList[position]
        holder.view.listener = this
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

    override fun CountryClick(vie: View) {
        val uuid = vie.country_uuid_Text.text.toString().toInt()
        val action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
        action.countryUuid = uuid
        Navigation.findNavController(vie).navigate(action)
    }

}