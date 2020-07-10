package com.auroraministudio.sehatqassignment.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.auroraministudio.sehatqassignment.R
import com.bumptech.glide.Glide

/**
 *
 * Created by Rio on 03/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@BindingAdapter("goneUnless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("goneUnlessReverse")
fun goneUnlessReverse(view: View, visible: Boolean) {
    view.visibility = if (visible) View.INVISIBLE else View.VISIBLE
}


@BindingAdapter("setImageUrl")
fun bindImages(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        Glide.with(imgView.context)
            .load(imgUrl)
            .into(imgView)
    }
}

@BindingAdapter("flagImageLoved")
fun bindImageLoveProduct(imgView: ImageView, loved: Int) {
    if (loved == 0) {
        imgView.setImageResource(R.drawable.v_ic_love_normal)
    } else {
        imgView.setImageResource(R.drawable.v_ic_love_pressed)
    }
}

@BindingAdapter("setAdapter")
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}
