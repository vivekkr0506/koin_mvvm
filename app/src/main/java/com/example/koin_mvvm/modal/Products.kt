package com.example.koin_mvvm.modal

import androidx.databinding.Bindable


data class Products(
    val data: ArrayList<Data>,
    val message: String,
    val status: String
)

data class Data(
    val product_inventory: ProductInventory,
    val product_master: ProductMaster,
    val product_merchantdising: ProductMerchantdising,
    val product_pricing: ProductPricing
)

data class ProductInventory(
    val cat_id: Int,
    val created_at: String,
    val dispatched_quantity: Int,
    val hub_id: Int,
    val live_inventory_at_source: Int,
    val merchant_delta: Int,
    val next_available_by: String,
    val product_id: String,
    val rm_buffer: Int,
    val slot_available: Int,
    val slot_custom_message: String,
    val stock_lock: Int,
    val stock_units: Int,
    val updated_at: String
)


data class ProductMaster(
    val created_at: String,
    val gross: String,
    val hsn_no: String,
    val net: String,
    val pieces: String,
    val pr_name: String,
    val pr_weight: String,
    val product_id: String,
    val slug: String,
    val status: Int,
    val text: String,
    val uom: String,
    val updated_at: String
)


data class ProductMerchantdising(
    val best_before: String,
    val city_id: Int,
    val cooking_time: String,
    val created_at: String,
    val cut_off_time: Int,
    val description: String,
    val display_order: Int,
    val gross_wt_img_pdp: String,
    val hub_id: Int,
    val inv_sort: Int,
    val is_combo: Int,
    val merchandise_name: String,
    val meta_description: String,
    val meta_keywords: String,
    val meta_title: String,
    val msite_desc: String,
    val net_wt_img_pdp: String,
    val no_of_piceces: String,
    val pdp_bestbefore_img_url: String,
    val pdp_cooktime_img_url: String,
    val pdp_gross_wt: String,
    val pdp_net_wt: String,
    val pdp_pieces_img_url: String,
    val pdp_serves_img_url: String,
    val pr_image: String,
    val pr_image_bucket: String,
    val pr_tags: String,
    val product_delivery_type: String,
    val product_header_tags: String,
    val product_id: String,
    val product_shortname: String,
    val score: Int,
    val serves: String,
    val short_description: String,
    val slider_images: String,
    val type: String,
    val updated_at: String,
    val usp_desc: String,
    val wt_msg: String
)


data class ProductPricing(
    val app_discount: Int,
    val base_discount: Any,
    val base_price: Any,
    val cgst: String,
    val city_discount: Int,
    val city_id: Int,
    val created_at: String,
    val hub_discount: Int,
    val hub_id: Int,
    val price_gram: String,
    val product_id: String,
    val sgst: String,
    val unit_gram: String,
    val updated_at: String
)