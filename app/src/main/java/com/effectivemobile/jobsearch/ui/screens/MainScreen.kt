package com.effectivemobile.jobsearch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.effectivemobile.jobsearch.R
import com.effectivemobile.jobsearch.ui.viewModels.VacanciesUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    vacanciesUiState: VacanciesUiState,
    modifier: Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        var searchQuery by remember { mutableStateOf("") }
        var searchBarActive by remember { mutableStateOf(false) }

        Row (
            modifier = Modifier
                .padding(8.dp)
        ){
            SearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                onSearch = { /* Нефункциональный элемент */ },
                active = searchBarActive,
                onActiveChange = { searchBarActive = it },
                placeholder = {
                    Text(
                        stringResource(R.string.searchHelp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                },
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.search_unselected),
                        contentDescription = null
                    )
                },
                colors = SearchBarDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .height(50.dp)
            ) {
                // Контент, который будет отображаться в раскрытом состоянии SearchBar, если это необходимо
            }
                Image(
                    painter = painterResource(id = R.drawable.filter_button),
                    contentDescription = stringResource(R.string.filter_button),
                    modifier = Modifier
                        .padding(start = 8.dp)
                )
            }


        when (vacanciesUiState) {
            is VacanciesUiState.Success -> VacanciesGridScreen(
                vacancies = vacanciesUiState.vacancySearch,
                modifier = modifier
            )
            is VacanciesUiState.Loading -> Text(text = "Loading")
            is VacanciesUiState.Error -> Text(text = "Error")
        }
    }
}