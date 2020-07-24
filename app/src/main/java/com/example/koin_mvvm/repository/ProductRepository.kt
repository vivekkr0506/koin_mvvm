package com.example.koin_mvvm.repository

import com.example.koin_mvvm.network.CatalogAPI

class ProductRepository(private val api: CatalogAPI) {

    private val cat_id : Int = 1
    private val hub_id : Int = 4
    private val token : String = "tk_40599ufkcpwi8sy"

    fun getAllProduct() = api.getProducts(cat_id,hub_id,token)
}