package com.auroraministudio.sehatqassignment.feature.profile.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.auroraministudio.sehatqassignment.R
import com.auroraministudio.sehatqassignment.databinding.ItemCartProductBinding
import com.auroraministudio.sehatqassignment.domain.model.Cart

/**
 *
 * Created by Rio on 10/07/20.
 * Email rio.aska35@gmail.com
 *
 */
class CartProductAdapter(private val clickListener: CartProductClickListener) :
    RecyclerView.Adapter<CartProductAdapter.CartProductViewHolder>() {

    var products: List<Cart> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartProductViewHolder {
        val withDataBinding: ItemCartProductBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CartProductViewHolder.LAYOUT,
            parent,
            false
        )
        return CartProductViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: CartProductViewHolder, position: Int) {
        holder.bind(clickListener, products[position])
    }

    override fun getItemCount(): Int = products.size

    class CartProductViewHolder(private val binding: ItemCartProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(click: CartProductClickListener, product: Cart) {
            binding.product = product
            binding.clickListener = click
            binding.executePendingBindings()
        }

        companion object {
            @LayoutRes
            val LAYOUT = R.layout.item_cart_product
        }
    }
}

class CartProductClickListener(val clickListener: (product: Cart) -> Unit) {
    fun onClick(product: Cart) = clickListener(product)
}