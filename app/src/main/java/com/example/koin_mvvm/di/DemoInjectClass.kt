package com.example.koin_mvvm.di

import android.util.Log
import android.view.View
import com.example.koin_mvvm.modal.Data
import com.example.koin_mvvm.utils.RecyclerViewClickListener

class DemoInjectClass : RecyclerViewClickListener {
    fun InjectIn(msg: String) {
        Log.e("VIVEK", msg)
    }

    override fun onClick(view: View?, data: Data, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onClickInject(msg: String) {
        Log.e("VIVEK", msg + "onClickInject")
    }
}
