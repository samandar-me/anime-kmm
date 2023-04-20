package com.sdk.animekmm.util

import com.sdk.animekmm.di.sharedModules
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(sharedModules)
    }
}