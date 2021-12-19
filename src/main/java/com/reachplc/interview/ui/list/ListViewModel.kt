package com.reachplc.interview.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.reachplc.interview.model.Product
import com.reachplc.interview.repo.ProductRepository
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    val productsResponse = MutableLiveData<List<Product>>()

    fun getProductsRequest(){
        viewModelScope.launch {
            ProductRepository().getProducts().run {
                productsResponse.value = this.products
            }
        }
    }
}