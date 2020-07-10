package com.auroraministudio.sehatqassignment.feature.search.presentation.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.auroraministudio.sehatqassignment.R
import com.auroraministudio.sehatqassignment.databinding.FragmentSearchBinding
import com.auroraministudio.sehatqassignment.feature.dashboard.view.DashboardActivity
import com.auroraministudio.sehatqassignment.feature.home.presentation.view.HomeFragmentDirections
import com.auroraministudio.sehatqassignment.feature.search.presentation.adapter.SearchProductAdapter
import com.auroraministudio.sehatqassignment.feature.search.presentation.adapter.SearchProductClickListener
import com.auroraministudio.sehatqassignment.feature.search.presentation.viewmodel.SearchViewModel
import com.auroraministudio.sehatqassignment.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModels()
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapterSearch: SearchProductAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        adapterSearch = SearchProductAdapter(SearchProductClickListener {
            searchViewModel.displayProductDetail(it)
        })

        binding.adapterSearch = adapterSearch

        setupUi()
        setupObserver()

        return binding.root
    }

    override fun onAttach(context: Context) {
        (activity as DashboardActivity).hideBottomMenu()
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        (activity as DashboardActivity).showBottomMenu()
    }

    private fun setupUi() {
        binding.etSearchKeyword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            @SuppressLint("DefaultLocale")
            override fun onTextChanged(keyword: CharSequence?, p1: Int, p2: Int, p3: Int) {
                searchViewModel.checkKeywordSearch(keyword.toString().trim().toLowerCase())
            }

        })

        binding.ivBackSearchFragment.setOnClickListener {
            requireActivity().hideKeyboard()
            this.findNavController().popBackStack()
        }
    }

    private fun setupObserver() {
        searchViewModel.listProduct.observe(viewLifecycleOwner, Observer {
            adapterSearch.products = it
        })

        searchViewModel.navigateToSelectedProduct.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(
                    SearchFragmentDirections.actionSearchFragmentToDetailProductFragment(it)
                )
                searchViewModel.displayCompleteProductDetail()
            }
        })
    }

}