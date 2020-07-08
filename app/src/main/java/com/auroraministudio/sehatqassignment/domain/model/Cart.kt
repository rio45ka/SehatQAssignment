package com.auroraministudio.sehatqassignment.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 *
 * Created by Rio on 08/07/20.
 * Email rio.aska35@gmail.com
 *
 */
@Parcelize
data class Cart(
    val id: String,
    val imageUrl: String,
    val title: String,
    val description: String,
    val price: String
) : Parcelable