package org.fungorn.gatewayapp

import android.app.Application
import org.fungorn.gatewayapp.di.appModule
import org.fungorn.gatewayapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GatewayApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@GatewayApp)

            modules(appModule + networkModule)
        }
    }
}