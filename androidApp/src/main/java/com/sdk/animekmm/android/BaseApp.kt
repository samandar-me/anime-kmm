package com.sdk.animekmm.android

import android.app.Application
import com.sdk.animekmm.android.di.androidModule
import com.sdk.animekmm.di.sharedModules
import org.koin.core.context.startKoin

class BaseApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(androidModule + sharedModules)
        }
    }
}