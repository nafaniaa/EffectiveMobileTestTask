package com.effectivemobile.jobsearch.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.effectivemobile.jobsearch.R
import com.effectivemobile.jobsearch.data.Vacancy
import com.effectivemobile.jobsearch.ui.viewModels.FavoritesViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun VacanciesGridScreen(
    viewModel: FavoritesViewModel = viewModel(),
    vacancies: List<Vacancy>,
    modifier: Modifier
){
    var showAllVacancies by remember { mutableStateOf(false) }
    val vacanciesToShow = if (showAllVacancies) vacancies else vacancies.take(3)

    LazyColumn(modifier = modifier){
        itemsIndexed(vacanciesToShow){ _, vacancy ->
            VacancyCard(
                vacancy = vacancy,
                modifier = modifier,
                isFavorite = false,
                onFavoriteClick = {
                    viewModel.toggleFavorite(vacancy)
                })
        }
        
        if(!showAllVacancies && vacancies.size > 3){
            item { 
                Button(
                    onClick = { showAllVacancies = true },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = MaterialTheme.colorScheme.tertiary
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(end = 8.dp, start = 8.dp)
                    ) {
                        Text(text = stringResource(
                            R.string.moreVacanciesButtonText,
                            vacancies.size - 3
                        ))
                }
            }
        }

    }

}