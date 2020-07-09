package com.auroraministudio.sehatqassignment.feature.search.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.auroraministudio.sehatqassignment.R
import com.auroraministudio.sehatqassignment.domain.model.Product
import com.auroraministudio.sehatqassignment.databinding.ItemProductBinding
import com.auroraministudio.sehatqassignment.databinding.ItemProductSearchBinding

/**
 *
 * Created by Rio on 09/07/20.
 * Email rio.aska35@gmail.com
 *
 */
class SearchProductAdapter(private val clickListener: SearchProductClickListener) :
    RecyclerView.Adapter<SearchProductAdapter.ProductViewHolder>() {

    var products: List<Product> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val withDataBinding: ItemProductSearchBinding = DataBindingUtil.inflate(
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

    class ProductViewHolder(private val binding: ItemProductSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(click: SearchProductClickListener, product: Product) {
            binding.product = product
            binding.clickListener = click
            binding.executePendingBindings()
        }

        companion object {
            @LayoutRes
            val LAYOUT = R.layout.item_product_search
        }
    }
}

class SearchProductClickListener(val clickListener: (product: Product) -> Unit) {
    fun onClick(product: Product) = clickListener(product)
}