package com.artur.marleyspoon

import android.app.Application
import com.artur.marleyspoon.di.dataSourceModule
import com.artur.marleyspoon.di.networkModule
import com.artur.marleyspoon.di.repositoryModule
import com.artur.marleyspoon.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarleySpoonApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MarleySpoonApp)
            modules(viewModelModule)
            modules(networkModule)
            modules(dataSourceModule)
            modules(repositoryModule)
        }
    }
}