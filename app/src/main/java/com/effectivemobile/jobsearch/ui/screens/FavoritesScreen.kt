package com.effectivemobile.jobsearch.ui.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.effectivemobile.jobsearch.ui.viewModels.FavoritesViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel = viewModel(),
    modifier: Modifier = Modifier
){
    val favoriteVacancies = viewModel.favorites

    if (favoriteVacancies.isEmpty()) {
        Text("Нет избранных вакансий", modifier = modifier.padding(16.dp))
    } else {
        LazyColumn(modifier = modifier) {
            items(favoriteVacancies) { vacancy ->
                VacancyCard(
                    vacancy = vacancy,
                    isFavorite = true,
                    onFavoriteClick = { viewModel.toggleFavorite(vacancy) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}