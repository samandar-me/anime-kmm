package com.sdk.animekmm.domain.use_case

import com.sdk.animekmm.domain.model.Anime
import com.sdk.animekmm.domain.repository.AnimeRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

typealias GetCharacterByIdBaseUseCase = BaseUseCase<Int, Anime>

class GetCharacterByIdUseCase : KoinComponent, GetCharacterByIdBaseUseCase {
    private val repository: AnimeRepository by inject()
    override suspend fun invoke(parameter: Int): Anime {
        return repository.getCharacterById(parameter)
    }
}