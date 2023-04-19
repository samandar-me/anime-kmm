package com.sdk.animekmm.di

import com.sdk.animekmm.data.remote.AnimeApi
import com.sdk.animekmm.data.remote.RemoteDataSource
import com.sdk.animekmm.data.repository.AnimeRepositoryImpl
import com.sdk.animekmm.domain.repository.AnimeRepository
import com.sdk.animekmm.domain.use_case.GetAllCharactersUseCase
import com.sdk.animekmm.domain.use_case.GetCharacterByIdUseCase
import com.sdk.animekmm.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    single {
        RemoteDataSource(get(),get())
    }
    factory { AnimeApi() }
}
private val utilityModule = module {
    factory {
        provideDispatcher()
    }
}

private val domainModule = module {
    single<AnimeRepository> {
        AnimeRepositoryImpl(get())
    }
    factory { GetAllCharactersUseCase() }
    factory { GetCharacterByIdUseCase() }
}
val sharedModules = listOf(dataModule, utilityModule, domainModule)