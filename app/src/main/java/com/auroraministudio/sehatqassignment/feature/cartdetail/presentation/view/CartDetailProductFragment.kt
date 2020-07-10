package com.auroraministudio.sehatqassignment.feature.cartdetail.presentation.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.auroraministudio.sehatqassignment.databinding.FragmentDetailCartProductBinding
import com.auroraministudio.sehatqassignment.domain.model.Cart
import com.auroraministudio.sehatqassignment.feature.cartdetail.presentation.viewmodel.CartDetailProductViewModel
import com.auroraministudio.sehatqassignment.feature.dashboard.view.DashboardActivity
import com.auroraministudio.sehatqassignment.utils.Const
import com.auroraministudio.sehatqassignment.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class CartDetailProductFragment : Fragment() {

    private val detailProductViewModel: CartDetailProductViewModel by viewModels()
    private lateinit var binding: FragmentDetailCartProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailCartProductBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = detailProductViewModel

        val news = arguments?.getParcelable<Cart>(Const.ARGUMENT_CART_DETAIL_PRODUCT)
        news?.let { detailProductViewModel.setData(it) }

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
        binding.ivBackDetailProductCart.setOnClickListener {
            requireActivity().hideKeyboard()
            this.findNavController().popBackStack()
        }

        binding.btnShareDetailProductCart.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${detailProductViewModel.product.value?.imageUrl}")
                type = "text/plain"
            }
            startActivity(sendIntent)
        }

        binding.btnLovedProductCart.setOnClickListener {
            when (detailProductViewModel.hasLikeProduct.value) {
                0 -> {
                    detailProductViewModel.actionAddLovedProduct()
                    binding.animLovedProductCart.setAnimation("like_anim.json")
                    binding.animLovedProductCart.playAnimation()
                    binding.animLovedProductCart.repeatCount = 0

                }
                1 -> {
                    detailProductViewModel.actionRemovedLoveProduct()
                }
            }
        }
    }

    private fun setupObserver() {
        detailProductViewModel.product.observe(viewLifecycleOwner, Observer {
            binding.product = it
        })

    }

}