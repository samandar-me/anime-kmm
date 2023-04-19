package com.sdk.animekmm.android.main

import com.sdk.animekmm.domain.model.Anime

data class MainState(
    val isLoading: Boolean = false,
    val error: String = "",
    val success: List<Anime> = emptyList()
)