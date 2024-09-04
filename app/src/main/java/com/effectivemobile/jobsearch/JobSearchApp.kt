package com.effectivemobile.jobsearch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.effectivemobile.jobsearch.ui.screens.BottomNavBar
import com.effectivemobile.jobsearch.ui.screens.FavoritesScreen
import com.effectivemobile.jobsearch.ui.screens.MainScreen
import com.effectivemobile.jobsearch.ui.screens.PlaceholderScreen
import com.effectivemobile.jobsearch.ui.screens.MainScreen
import com.effectivemobile.jobsearch.ui.viewModels.VacanciesViewModel

@Composable
fun JobSearchApp(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
) {
    val navController = rememberNavController()
    val vacanciesViewModel: VacanciesViewModel =
        viewModel(factory = VacanciesViewModel.Factory)

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "search",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("search") {
                Scaffold(
                    modifier = modifier
                        .fillMaxSize()
                ) {
                    Surface(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(it)
                    ) {
                        MainScreen(
                            vacanciesUiState = vacanciesViewModel.vacanciesUiState,
                            modifier = modifier
                        )
                    }
                }
            }
            composable("favorites") {
                Surface(
                    modifier = modifier
                        .fillMaxSize()
                ) {
                    FavoritesScreen()
                }
            }
            composable("responses") {
                PlaceholderScreen("Nothing")
            }
            composable("messages") {
                PlaceholderScreen("Nothing")
            }
            composable("profile") {
                PlaceholderScreen("Nothing")
            }
        }
    }
}

