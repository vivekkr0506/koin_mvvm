package com.example.koin_mvvm

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.koin_mvvm.databinding.ActivityMainBinding
import com.example.koin_mvvm.di.DemoInjectClass
import com.example.koin_mvvm.modal.Data
import com.example.koin_mvvm.utils.RecyclerViewClickListener
import com.example.koin_mvvm.view.ui.ProductListAdapter
import com.example.koin_mvvm.viewModel.LoadingState
import com.example.koin_mvvm.viewModel.ProductsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(),
    RecyclerViewClickListener {
    private val productViewModel by  viewModel<ProductsViewModel>()
    var productListAdapter: ProductListAdapter? = null
    private var mContext: Context = this

    //injecting the class
    val demoInjectClass: DemoInjectClass by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val activityMainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.lifecycleOwner = this
        activityMainBinding.viewModel = productViewModel
        activityMainBinding.adapter = productListAdapter

        //use all function here of injected class
        demoInjectClass.InjectIn("VIVEK BY INJECT KOIN simple msg")
        demoInjectClass.onClickInject("INJECT KOIN Interface")

        productViewModel.data.observe(this, Observer {
            //Product List Adapter
            initAdapter(it)
            })

        productViewModel.loadingState.observe(this, Observer {
            when (it.status) {
                LoadingState.Status.FAILED -> Toast.makeText(baseContext, it.msg, Toast.LENGTH_SHORT).show()
                LoadingState.Status.RUNNING -> Toast.makeText(baseContext, "Loading", Toast.LENGTH_SHORT).show()
                LoadingState.Status.SUCCESS -> Toast.makeText(baseContext, "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }


    //Adapter product list
    private fun initAdapter(productData: ArrayList<Data>) {
        productListAdapter = ProductListAdapter(productData, this)
        rvProductList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(mContext)
            adapter = productListAdapter
        }
    }

    override fun onClick(view: View?, data: Data, position: Int) {
        when (view?.id) {
            R.id.img_item -> {
                Toast.makeText(mContext, data.product_master.pr_name,Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onClickInject(msg: String) {
        TODO("Not yet implemented")
    }
    fun getAppContext(): Context? {
        return mContext
    }
}

