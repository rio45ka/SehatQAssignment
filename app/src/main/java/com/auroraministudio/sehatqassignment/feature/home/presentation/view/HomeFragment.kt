package com.auroraministudio.sehatqassignment.feature.home.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.auroraministudio.sehatqassignment.R
import com.auroraministudio.sehatqassignment.databinding.FragmentHomeBinding
import com.auroraministudio.sehatqassignment.feature.home.presentation.adapter.CategoryAdapter
import com.auroraministudio.sehatqassignment.feature.home.presentation.adapter.CategoryClickListener
import com.auroraministudio.sehatqassignment.feature.home.presentation.adapter.ProductAdapter
import com.auroraministudio.sehatqassignment.feature.home.presentation.adapter.ProductClickListener
import com.auroraministudio.sehatqassignment.feature.home.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import timber.log.Timber

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapterProduct: ProductAdapter
    private lateinit var adapterCategory: CategoryAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        adapterProduct = ProductAdapter(ProductClickListener {
            homeViewModel.displayProductDetail(it)
        })

        adapterCategory = CategoryAdapter(CategoryClickListener {
            Timber.e(it.name)
        })

        binding.adapterProduct = adapterProduct
        binding.rvCategoryHome.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterCategory
        }

        setupClick()
        setupObserver()

        return binding.root
    }

    private fun setupClick() {
        binding.btnSearchHome.setOnClickListener {
            this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToSearchFragment())
        }
    }

    private fun setupObserver() {
        homeViewModel.listProduct.observe(viewLifecycleOwner, Observer {
            adapterProduct.products = it
        })

        homeViewModel.listCategory.observe(viewLifecycleOwner, Observer {
            adapterCategory.categories = it
        })

        homeViewModel.errorFetchData.observe(viewLifecycleOwner, Observer {
            if (it != null) Toast.makeText(context, "Couldn't refresh, $it", Toast.LENGTH_SHORT)
                .show()
        })

        homeViewModel.navigateToSelectedProduct.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailProductFragment(it))
                homeViewModel.displayCompleteProductDetail()
            }
        })
    }

}