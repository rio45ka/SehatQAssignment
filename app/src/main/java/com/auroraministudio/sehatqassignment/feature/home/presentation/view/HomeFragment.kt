package com.auroraministudio.sehatqassignment.feature.home.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
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
        binding.lifecycleOwner = this

        adapterProduct = ProductAdapter(ProductClickListener { product ->
            Timber.e(product.title)
        })

        adapterCategory = CategoryAdapter(CategoryClickListener { category ->
            Timber.e(category.name)
        })

        binding.adapterProduct = adapterProduct
        binding.rvCategoryHome.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterCategory
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel.listProduct.observe(viewLifecycleOwner, Observer {
            adapterProduct.products = it
        })

        homeViewModel.listCategory.observe(viewLifecycleOwner, Observer {
            adapterCategory.categories = it
        })
    }

}