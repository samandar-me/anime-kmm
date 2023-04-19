package com.sdk.animekmm.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class AnimeDTO(
    val `data`: List<Data>,
    val pagination: Pagination
)