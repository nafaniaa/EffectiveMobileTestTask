package com.effectivemobile.jobsearch.ui.screens

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.effectivemobile.jobsearch.ui.viewModels.VacanciesUiState

@Composable
fun MainScreen(
    vacanciesUiState: VacanciesUiState,
    modifier: Modifier
){
    when(vacanciesUiState){
        is VacanciesUiState.Success -> VacanciesGridScreen(
            vacancies = vacanciesUiState.vacancySearch,
            modifier = modifier )
        is VacanciesUiState.Loading -> Text(text = "Loading")
        is VacanciesUiState.Error -> Text(text = "Error")
    }
}