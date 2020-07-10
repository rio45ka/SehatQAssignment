package com.auroraministudio.sehatqassignment.feature.profile.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.auroraministudio.sehatqassignment.databinding.FragmentProfileBinding
import com.auroraministudio.sehatqassignment.feature.profile.presentation.adapter.CartProductAdapter
import com.auroraministudio.sehatqassignment.feature.profile.presentation.adapter.CartProductClickListener
import com.auroraministudio.sehatqassignment.feature.profile.presentation.viewmodel.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class ProfileFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by viewModels()
    private lateinit var cartAdapter: CartProductAdapter
    private lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        cartAdapter = CartProductAdapter(CartProductClickListener {
            profileViewModel.displayProductDetail(it)
        })

        setupObserver()

        binding.adapterCart = cartAdapter

        return binding.root
    }

    private fun setupObserver() {
        profileViewModel.listProduct.observe(viewLifecycleOwner, Observer {
            cartAdapter.products = it
        })

        profileViewModel.navigateToSelectedProduct.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToCartDetailProductFragment(it))
                profileViewModel.displayCompleteProductDetail()
            }
        })
    }

}