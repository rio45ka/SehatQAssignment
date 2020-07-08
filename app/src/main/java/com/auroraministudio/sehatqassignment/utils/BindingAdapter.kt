package com.auroraministudio.sehatqassignment.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter

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


