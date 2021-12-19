package com.reachplc.interview.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.reachplc.interview.R
import com.reachplc.interview.databinding.FragmentDetailBinding
import com.reachplc.interview.model.Product

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var viewBinding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initListeners()
        getArgs()
    }

    private fun getArgs() {
        arguments?.getParcelable<Product>(KEY_DATA).let {
            viewBinding.apply {
                description.text = it?.description
                title.text = it?.name
                price.text = "${it?.price}€"
                Glide.with(requireContext())
                    .load(it?.image)
                    .into(image)
            }
        }
    }

    private fun initListeners() {
        viewBinding.apply {

        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
    }

    companion object{
        const val KEY_DATA = "data"
    }

}