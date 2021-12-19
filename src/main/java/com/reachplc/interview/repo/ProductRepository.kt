package com.reachplc.interview.repo

import com.reachplc.interview.data.remote.ProductsResponse
import com.reachplc.interview.di.AppContainer

class ProductRepository {
    suspend fun getProducts(): ProductsResponse = AppContainer().retrofit.getProducts()
}