package com.auroraministudio.sehatqassignment.feature.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.auroraministudio.sehatqassignment.R
import com.auroraministudio.sehatqassignment.domain.model.Category
import com.auroraministudio.sehatqassignment.databinding.ItemCategoryBinding

/**
 *
 * Created by Rio on 09/07/20.
 * Email rio.aska35@gmail.com
 *
 */
class CategoryAdapter(private val clickListener: CategoryClickListener) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var categories: List<Category> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val withDataBinding: ItemCategoryBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CategoryViewHolder.LAYOUT,
            parent,
            false
        )
        return CategoryViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(clickListener, categories[position])
    }

    override fun getItemCount(): Int = categories.size

    class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(click: CategoryClickListener, category: Category) {
            binding.category = category
            binding.clickListener = click
            binding.executePendingBindings()
        }

        companion object {
            @LayoutRes
            val LAYOUT = R.layout.item_category
        }
    }
}

class CategoryClickListener(val clickListener: (category: Category) -> Unit) {
    fun onClick(category: Category) = clickListener(category)
}