package com.sdk.animekmm.domain.repository

import com.sdk.animekmm.domain.model.Anime

interface AnimeRepository {
    suspend fun getAllCharacters(): List<Anime>
    suspend fun getCharacterById(id: Int): Anime
}