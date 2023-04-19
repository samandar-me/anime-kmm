package com.sdk.animekmm.data.remote

import com.sdk.animekmm.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val api: AnimeApi,
    private val dispatcher: Dispatcher
) {
    suspend fun getAllCharacters() = withContext(dispatcher.io) {
        api.getAllCharacters()
    }
    suspend fun getCharacterById(id: Int) = withContext(dispatcher.io) {
        api.getCharacterById(id)
    }
}