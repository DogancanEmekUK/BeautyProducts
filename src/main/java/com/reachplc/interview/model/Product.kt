package com.reachplc.interview.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: String = "",
    val name: String = "",
    val image: String = "",
    val description: String = "",
    val price: Double = 0.0,
    ): Parcelable