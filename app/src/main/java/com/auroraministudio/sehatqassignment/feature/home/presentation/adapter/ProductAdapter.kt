package com.auroraministudio.sehatqassignment.feature.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.auroraministudio.sehatqassignment.R
import com.auroraministudio.sehatqassignment.data.remote.Product
import com.auroraministudio.sehatqassignment.databinding.ItemProductBinding

/**
 *
 * Created by Rio on 09/07/20.
 * Email rio.aska35@gmail.com
 *
 */
class ProductAdapter(private val clickListener: ProductClickListener) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var products: List<Product> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val withDataBinding: ItemProductBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ProductViewHolder.LAYOUT,
            parent,
            false
        )
        return ProductViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(clickListener, products[position])
    }

    override fun getItemCount(): Int = products.size

    class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(click: ProductClickListener, product: Product) {
            binding.product = product
            binding.clickListener = click
            binding.executePendingBindings()
        }

        companion object {
            @LayoutRes
            val LAYOUT = R.layout.item_product
        }
    }
}

class ProductClickListener(val clickListener: (product: Product) -> Unit) {
    fun onClick(product: Product) = clickListener(product)
}