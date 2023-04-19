package com.sdk.animekmm.domain.model


data class Anime(
    val id: Int,
    val url: String,
    val image: String,
    val name: String,
    val kanji: String,
    val favorites: Int,
    val about: String,
    val nickNames: List<String>
)