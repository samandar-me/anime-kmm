package com.sdk.animekmm.data.repository

import com.sdk.animekmm.data.mapper.toAnime
import com.sdk.animekmm.data.remote.RemoteDataSource
import com.sdk.animekmm.domain.model.Anime
import com.sdk.animekmm.domain.repository.AnimeRepository

internal class AnimeRepositoryImpl(
    private val dataSource: RemoteDataSource
): AnimeRepository {
    override suspend fun getAllCharacters(): List<Anime> {
        return dataSource.getAllCharacters().data.map { it.toAnime() }
    }

    override suspend fun getCharacterById(id: Int): Anime {
        return dataSource.getCharacterById(id).toAnime()
    }
}