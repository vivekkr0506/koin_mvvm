package com.example.koin_mvvm.network

import com.example.koin_mvvm.modal.Products
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CatalogAPI{
    @GET("catalog/products/all")
    fun getProducts(@Query("cat_id") cat_id: Int,
                    @Query("hub_id") hub_id: Int,
                    @Header("token") token: String): Call<Products>
}