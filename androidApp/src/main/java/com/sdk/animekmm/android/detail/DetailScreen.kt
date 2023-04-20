package com.sdk.animekmm.android.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sdk.animekmm.android.component.Loading
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun DetailScreen(
    id: Int
) {
    val viewModel: DetailViewModel = koinViewModel(
        parameters = {
            parametersOf(id)
        }
    )
    val state by viewModel.uiState.collectAsState()

    if (state.isLoading) {
        Loading()
    }
    println("$state")
    state.success?.let { anime ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(10.dp)
        ) {
            AsyncImage(
                model = anime.image,
                contentDescription = "image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = anime.kanji,
                style = MaterialTheme.typography.h3,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = anime.name,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = anime.about,
                style = MaterialTheme.typography.caption
            )
        }
    }
}