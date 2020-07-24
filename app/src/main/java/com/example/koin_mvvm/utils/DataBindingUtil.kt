package com.example.koin_mvvm.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.koin_mvvm.R
import com.example.koin_mvvm.modal.Data
import com.example.koin_mvvm.view.ui.ProductListAdapter


object DataBindingUtil {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView?, imgUrl: String?) {
        Glide.with(imageView!!.context)
            .load(imgUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.product_place_holder)
            .error(R.drawable.product_place_holder)
            .fallback(R.drawable.ic_launcher_foreground)
            .into(imageView);
    }

    @JvmStatic
    @BindingAdapter("productName")
    fun setProductName(textView: TextView?, productName: String?) {
        textView?.text = productName
    }

    @JvmStatic
    @BindingAdapter("productBasePrice")
    fun setProductBasePrice(textView: TextView?, basePrice: String?) {
        textView?.text = basePrice
    }

    @BindingAdapter("data")
    @JvmStatic
    fun setListProduct(recyclerView: RecyclerView, items: ArrayList<Data>?) {
        with(recyclerView.adapter as ProductListAdapter?) {
            this?.setData(items)
        }
    }
}