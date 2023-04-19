package com.sdk.animekmm.data.remote

import kotlinx.serialization.Serializable

@Serializable
data class Pagination(
    val current_page: Int,
    val has_next_page: Boolean,
    val last_visible_page: Int
)