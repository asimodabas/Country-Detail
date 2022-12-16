package com.asimodabas.country_detail.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.asimodabas.country_detail.R
import com.asimodabas.country_detail.databinding.FragmentCountryBinding
import com.asimodabas.country_detail.util.downloadUrl
import com.asimodabas.country_detail.util.placeHolderProgesBar
import com.asimodabas.country_detail.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {

    private lateinit var viewModel: CountryViewModel
    private lateinit var dataBinding: FragmentCountryBinding
    private var countryUuid = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_country,container,false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = CountryFragmentArgs.fromBundle(it).countryUuid
        }

        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getDataRoom(countryUuid)


        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country ->
            country?.let {

                dataBinding.selectedCountry = country
            }
        })
    }
}