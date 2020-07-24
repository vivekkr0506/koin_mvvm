package com.example.koin_mvvm

import android.app.Application
import com.example.koin_mvvm.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LiciousApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(org.koin.core.logger.Level.DEBUG)
            androidContext(this@LiciousApp)
            modules(listOf(
                repositoryModule,
                viewModelModule,
                retrofitModule,
                apiModule,
                demoModule
            ))
        }
    }
    
}