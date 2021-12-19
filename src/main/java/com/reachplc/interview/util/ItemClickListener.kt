package com.reachplc.interview.util

import com.reachplc.interview.model.Product

interface ItemClickListener {
    fun onItemClicked(model: Product)
}