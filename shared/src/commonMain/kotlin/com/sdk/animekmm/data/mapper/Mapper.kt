package com.sdk.animekmm.data.mapper

import com.sdk.animekmm.data.remote.Data
import com.sdk.animekmm.domain.model.Anime

fun Data.toAnime(): Anime {
    return Anime(
        id = mal_id,
        url = url,
        image = images.jpg.image_url,
        name = name,
        kanji = name_kanji,
        favorites = favorites,
        about = about,
        nickNames = nicknames
    )
}