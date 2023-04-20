package com.sdk.animekmm.android.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.sdk.animekmm.android.component.AnimeItem
import com.sdk.animekmm.android.component.Loading
import com.sdk.animekmm.android.component.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = koinViewModel(),
    navHostController: NavHostController
) {
    val state by viewModel.uiState.collectAsState()

    if (state.isLoading) {
        Loading()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(
            items = state.success,
            key = { it.id }
        ) {
            AnimeItem(
                anime = it,
                onClick = {
                    navHostController.navigate("detail_screen/${it.id}")
                }
            )
        }
    }
}