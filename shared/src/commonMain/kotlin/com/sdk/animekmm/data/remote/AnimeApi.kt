package com.sdk.animekmm.data.remote

import io.ktor.client.call.body
import io.ktor.client.request.get

private const val BASE_URL = "https://api.jikan.moe/v4"

internal class AnimeApi : ApiService() {
    suspend fun getAllCharacters(): AnimeDTO =
        client.get("$BASE_URL/top/characters").body()

    suspend fun getCharacterById(id: Int): DataResponse =
        client.get("$BASE_URL/characters/$id").body()
}