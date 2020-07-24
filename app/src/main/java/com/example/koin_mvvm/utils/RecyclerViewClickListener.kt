package com.example.koin_mvvm.utils

import android.view.View
import com.example.koin_mvvm.modal.Data
import com.example.koin_mvvm.viewModel.ProductsViewModel

interface RecyclerViewClickListener {
    fun onClick(view: View?,data:Data,position:Int)
    fun onClickInject(msg : String)
}
