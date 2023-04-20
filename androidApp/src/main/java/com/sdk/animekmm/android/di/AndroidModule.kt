package com.sdk.animekmm.android.di

import com.sdk.animekmm.android.detail.DetailViewModel
import com.sdk.animekmm.android.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel { MainViewModel(get()) }
    viewModel {
        DetailViewModel(
            useCase = get(),
            id = it.get()
        )
    }
}