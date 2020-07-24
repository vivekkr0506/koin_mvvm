package com.example.koin_mvvm.di

import com.example.koin_mvvm.network.CatalogAPI
import com.example.koin_mvvm.repository.ProductRepository
import com.example.koin_mvvm.utils.Constant.BASE_URL
import com.example.koin_mvvm.viewModel.ProductsViewModel
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel {
        ProductsViewModel(get())
    }
}

val repositoryModule = module {
    single {
        ProductRepository(get())
    }
}
val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): CatalogAPI {
        return retrofit.create(CatalogAPI::class.java)
    }
    single { provideUseApi(get()) }
}

val demoModule = module {
    single { DemoInjectClass() }
}


val retrofitModule = module {
    
    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }
    fun provideHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
       return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
    
    }
    
    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }
    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(), get()) }
}

