package com.sdk.animekmm.domain.use_case

import com.sdk.animekmm.domain.model.Anime
import com.sdk.animekmm.domain.repository.AnimeRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

typealias GetAllCharactersBaseUseCase = BaseUseCase<Unit,List<Anime>>

class GetAllCharactersUseCase:KoinComponent, GetAllCharactersBaseUseCase {
    private val repository: AnimeRepository by inject()
    override suspend fun invoke(parameter: Unit): List<Anime> {
        return repository.getAllCharacters()
    }
}