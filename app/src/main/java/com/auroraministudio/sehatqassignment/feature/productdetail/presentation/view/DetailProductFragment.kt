package com.auroraministudio.sehatqassignment.feature.productdetail.presentation.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.auroraministudio.sehatqassignment.databinding.FragmentDetailProductBinding
import com.auroraministudio.sehatqassignment.domain.model.Product
import com.auroraministudio.sehatqassignment.feature.dashboard.view.DashboardActivity
import com.auroraministudio.sehatqassignment.feature.productdetail.presentation.viewmodel.DetailProductViewModel
import com.auroraministudio.sehatqassignment.utils.Const
import com.auroraministudio.sehatqassignment.utils.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@AndroidEntryPoint
@ExperimentalCoroutinesApi
class DetailProductFragment : Fragment() {

    private val detailProductViewModel: DetailProductViewModel by viewModels()
    private lateinit var binding: FragmentDetailProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailProductBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = detailProductViewModel

        val news = arguments?.getParcelable<Product>(Const.ARGUMENT_DETAIL_PRODUCT)
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
        binding.ivBackSearchDetailProduct.setOnClickListener {
            requireActivity().hideKeyboard()
            this.findNavController().popBackStack()
        }

        binding.btnShareDetailProduct.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "${detailProductViewModel.product.value?.imageUrl}")
                type = "text/plain"
            }
            startActivity(sendIntent)
        }

        binding.btnLovedProduct.setOnClickListener {
            when (detailProductViewModel.hasLikeProduct.value) {
                0 -> {
                    detailProductViewModel.actionAddLovedProduct()
                    binding.animLovedProduct.setAnimation("like_anim.json")
                    binding.animLovedProduct.playAnimation()
                    binding.animLovedProduct.repeatCount = 0

                }
                1 -> { detailProductViewModel.actionRemovedLoveProduct() }
            }
        }
    }

    private fun setupObserver() {
        detailProductViewModel.product.observe(viewLifecycleOwner, Observer {
            binding.product = it
        })

        detailProductViewModel.successBuyProduct.observe(viewLifecycleOwner, Observer {
            if (null != it || it == true) Toast.makeText(context, "Success buy product!", Toast.LENGTH_SHORT).show()
        })
    }

}