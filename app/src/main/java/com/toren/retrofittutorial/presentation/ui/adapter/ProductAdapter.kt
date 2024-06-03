package com.toren.retrofittutorial.presentation.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.toren.retrofittutorial.databinding.ProductRowBinding
import com.toren.retrofittutorial.domain.model.Product

class ProductAdapter(
    private val productList: MutableList<Product>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()
{

    inner class ProductViewHolder(val binding: ProductRowBinding) :
            RecyclerView.ViewHolder(binding.root),
            View.OnClickListener {
                init {
                    binding.root.setOnClickListener(this)
                }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(productList[position])
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductRowBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(productList[position].images[0])
            .into(holder.binding.productImgV)
        holder.binding.apply {
            productNameTxtV.text = productList[position].title
            productBrandTxtV.text = productList[position].brand
            productPriceTxtV.text = "${productList[position].price} TL"
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateProducts(newProducts: List<Product>) {
        productList.clear()
        productList.addAll(newProducts)
        notifyDataSetChanged()
    }
}