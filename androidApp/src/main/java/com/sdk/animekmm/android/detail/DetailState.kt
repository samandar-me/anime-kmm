package com.sdk.animekmm.android.detail

import com.sdk.animekmm.domain.model.Anime

data class DetailState(
    val isLoading: Boolean = false,
    val error: String = "",
    val success: Anime? = null
)