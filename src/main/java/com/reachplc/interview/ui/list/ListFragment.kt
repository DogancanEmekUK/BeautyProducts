package com.reachplc.interview.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.reachplc.interview.BeautyProductsApp
import com.reachplc.interview.R
import com.reachplc.interview.adapter.ProductListAdapter
import com.reachplc.interview.databinding.FragmentListBinding
import com.reachplc.interview.model.Product
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var viewModel: ListViewModel
    private lateinit var viewBinding: FragmentListBinding
    private lateinit var productAdapter: ProductListAdapter

    private val productObserver: Observer<in List<Product>> = Observer {
        productAdapter.updateProductList(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentListBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        initViewModel()
        initListeners()
        initAdapter()
        fetchProducts()

    }

    private fun initAdapter(){
        productAdapter = ProductListAdapter { _productModel ->
            findNavController().navigate(
                R.id.action_fragmentList_to_detailFragment,
                bundleOf(KEY_DATA to _productModel)
            )
        }
        viewBinding.recyclerView.adapter = productAdapter
    }

    private fun fetchProducts(){
        viewModel.getProductsRequest()
    }

    private fun initListeners(){
        viewModel = ViewModelProvider(this)[ListViewModel::class.java].apply {
            productsResponse.observe(viewLifecycleOwner, productObserver)
        }
    }

    private fun initViewModel(){
        viewBinding.apply {

        }
    }

    companion object{
        const val KEY_DATA = "data"
    }

}