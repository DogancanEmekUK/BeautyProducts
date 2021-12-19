package com.reachplc.interview.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reachplc.interview.R
import com.reachplc.interview.databinding.RecyclerListRowBinding
import com.reachplc.interview.model.Product

class ProductListAdapter(private val listener: (model: Product) -> Unit):
    RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    private var products: MutableList<Product> = mutableListOf()
    private var lastPosition = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListAdapter.ProductListViewHolder {
        RecyclerListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false).run {
            return ProductListViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bind(position)
        setAnimation(holder.itemView, position)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    private fun setAnimation(viewToAnimate: View, position: Int){
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(viewToAnimate.context, android.R.anim.slide_in_left)
            animation.duration = 2000
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateProductList(list: List<Product>){
        products.clear()
        products.addAll(list)
        notifyDataSetChanged()
    }

    inner class ProductListViewHolder(private val binding: RecyclerListRowBinding):
        RecyclerView.ViewHolder(binding.root)  {

            fun bind(position: Int){
                binding.apply {
                    id.text = products[position].id
                    name.text = products[position].name
                    description.text = description.context.getString(R.string.description)
                    price.text = price.context.getString(
                        R.string.price_placeholder,
                        products[position].price.toString()
                    )
                    Glide.with(image.context)
                        .load(products[position].image)
                        .placeholder(ContextCompat.getDrawable(image.context, R.drawable.ic_launcher_background))
                        .into(image)
                    root.setOnClickListener {
                        listener(products[position])
                }
            }
        }
    }
}