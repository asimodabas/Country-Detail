package com.asimodabas.country_detail.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.asimodabas.country_detail.R
import com.asimodabas.country_detail.adapter.CountryAdapter
import com.asimodabas.country_detail.viewmodel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.countryErrorText
import kotlinx.android.synthetic.main.fragment_feed.countryList
import kotlinx.android.synthetic.main.fragment_feed.countryLoadingprogessBar
import kotlinx.android.synthetic.main.fragment_feed.swipeRefreshLayout

class FeedFragment : Fragment(R.layout.fragment_feed) {

    private lateinit var viewModel: FeedViewModel
    private var countryAdapter = CountryAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)
        viewModel.refreshData()

        countryList.layoutManager = LinearLayoutManager(context)
        countryList.adapter = countryAdapter

        swipeRefreshLayout.setOnRefreshListener {

            countryList.visibility = View.GONE
            countryErrorText.visibility = View.GONE
            countryLoadingprogessBar.visibility = View.VISIBLE

            viewModel.refreshAPI()

            swipeRefreshLayout.isRefreshing = false
        }

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.countries.observe(viewLifecycleOwner, Observer { countrries ->

            countrries?.let {
                countryList.visibility = View.VISIBLE
                countryAdapter.updateCountryList(countrries)
            }
        })

        viewModel.countryError.observe(viewLifecycleOwner, Observer { error ->
            error?.let {
                if (it) {
                    countryErrorText.visibility = View.VISIBLE
                } else {
                    countryErrorText.visibility = View.GONE
                }
            }
        })

        viewModel.countryLoading.observe(viewLifecycleOwner, Observer { loading ->
            loading?.let {
                if (it) {
                    countryLoadingprogessBar.visibility = View.VISIBLE
                    countryList.visibility = View.GONE
                    countryErrorText.visibility = View.GONE
                } else {
                    countryLoadingprogessBar.visibility = View.GONE
                }
            }
        })
    }
}