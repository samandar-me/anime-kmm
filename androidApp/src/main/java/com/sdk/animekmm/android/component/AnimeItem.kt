package com.sdk.animekmm.android.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sdk.animekmm.domain.model.Anime

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AnimeItem(
    modifier: Modifier = Modifier,
    anime: Anime,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier.height(270.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = anime.image,
                contentDescription = "image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .weight(1.2f)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp))
            )
            Column(modifier = Modifier.padding(10.dp).weight(1f)) {
                Text(
                    text = anime.kanji,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = anime.name,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body1,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = anime.about,
                    style = MaterialTheme.typography.caption,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}