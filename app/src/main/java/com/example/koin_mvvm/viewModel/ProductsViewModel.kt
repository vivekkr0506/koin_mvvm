package com.example.koin_mvvm.viewModel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koin_mvvm.modal.*
import com.example.koin_mvvm.repository.ProductRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProductsViewModel(private val repo: ProductRepository) : ViewModel(),
    Callback<Products> {

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

  /*  val _data: ObservableList<ArrayList<Data>> = ObservableArrayList()
    val data: ObservableList<ArrayList<Data>>
        get() = _data*/

      val _data: MutableLiveData<ArrayList<Data>> = MutableLiveData()
    val data: MutableLiveData<ArrayList<Data>>
        get() = _data
    init {
        fetchData()
    }

    private fun fetchData() {
        _loadingState.postValue(LoadingState.LOADING)
        repo.getAllProduct().enqueue(this)

    }

    override fun onFailure(call: Call<Products>, t: Throwable) {
        _loadingState.postValue(LoadingState.error(t.message))
    }

    override fun onResponse(call: Call<Products>, response: Response<Products>) {
        if (response.isSuccessful) {
            /*
               if _data is ObservableList
             */
           // _data.add(response.body()!!.data)
            _data.postValue(response.body()!!.data)
            _loadingState.postValue(LoadingState.LOADED)
        } else {
            _loadingState.postValue(LoadingState.error(response.errorBody().toString()))
        }
    }
}



