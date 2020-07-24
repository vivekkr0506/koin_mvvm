package com.example.koin_mvvm.view.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.koin_mvvm.R
import com.example.koin_mvvm.databinding.CatalogItemListBinding
import com.example.koin_mvvm.modal.Data
import com.example.koin_mvvm.utils.RecyclerViewClickListener
import com.example.koin_mvvm.BR

class ProductListAdapter(
    var productData: ArrayList<Data>?,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val viewDataBinding = DataBindingUtil.inflate<CatalogItemListBinding>(
            LayoutInflater.from(parent.getContext()),
            R.layout.catalog_item_list,
            parent,
            false
        )
        return ProductViewHolder(viewDataBinding)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        productData?.get(position)?.let { holder.bind(it, listener,position) }
    }
    override fun getItemCount(): Int {
        return productData!!.size
    }

    class ProductViewHolder(private val recyclerviewProductBinding: ViewDataBinding) : RecyclerView.ViewHolder(recyclerviewProductBinding.getRoot()) {

        fun bind(obj: Data, handler: RecyclerViewClickListener?, pos: Int) {
            recyclerviewProductBinding.setVariable(BR.products, obj)
            recyclerviewProductBinding.setVariable(BR.handler, handler)
            recyclerviewProductBinding.setVariable(BR.pos, pos)
            recyclerviewProductBinding.executePendingBindings()
        }
    }
    /**
     * adding data for the first time in the list and scroll if required to last position
     *
     * @param productData
     */
    fun setData(productData: ArrayList<Data>?) {
        this.productData = productData
        notifyDataSetChanged()
    }
}