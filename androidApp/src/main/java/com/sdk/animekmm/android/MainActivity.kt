package com.sdk.animekmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sdk.animekmm.android.component.CustomTopAppBar
import com.sdk.animekmm.android.component.Screen
import com.sdk.animekmm.android.detail.DetailScreen
import com.sdk.animekmm.android.main.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val navController = rememberNavController()
            val backStack by navController.currentBackStackEntryAsState()
            val title = when (backStack?.destination?.route) {
                Screen.Main.route -> "Anime Characters"
                Screen.Detail.route -> "Anime Details"
                else -> ""
            }
            Scaffold(
                scaffoldState = scaffoldState,
                topBar = {
                    CustomTopAppBar(
                        isNavVisible = title == "Anime Details",
                        onBack = { navController.popBackStack() },
                        title = title
                    )
                }
            ) { padding ->
                NavHost(
                    navController = navController,
                    startDestination = Screen.Main.route,
                    modifier = Modifier.padding(padding)
                ) {
                    composable(route = Screen.Main.route) {
                        MainScreen(navHostController = navController)
                    }
                    composable(route = Screen.Detail.route) {
                        val id = it.arguments?.getString("id") ?: "45627"
                        DetailScreen(id = id.toInt())
                    }
                }
            }
        }
    }
}


