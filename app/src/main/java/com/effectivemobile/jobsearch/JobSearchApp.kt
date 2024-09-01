package com.effectivemobile.jobsearch

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.effectivemobile.jobsearch.ui.screens.MainScreen
import com.effectivemobile.jobsearch.ui.viewModels.VacanciesViewModel

@Composable
fun JobSearchApp(
    modifier: Modifier = Modifier
){
    val vacanciesViewModel : VacanciesViewModel =
        viewModel(factory = VacanciesViewModel.Factory)

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
