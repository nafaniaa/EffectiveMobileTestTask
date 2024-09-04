package com.effectivemobile.jobsearch.ui.viewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.effectivemobile.jobsearch.data.Vacancy


class FavoritesViewModel : ViewModel() {
    private val _vacancies = mutableStateListOf<Vacancy>()
    val vacancies: List<Vacancy> get() = _vacancies

    private val _favorites = mutableStateListOf<Vacancy>()
    val favorites: List<Vacancy> get() = _favorites

    fun toggleFavorite(vacancy: Vacancy) {
        vacancy.isFavorite = !(vacancy.isFavorite ?: false)
        if (vacancy.isFavorite == true) {
            _favorites.add(vacancy)
        } else {
            _favorites.remove(vacancy)
        }
    }

    fun addVacancies(newVacancies: List<Vacancy>) {
        _vacancies.clear()
        _vacancies.addAll(newVacancies)
    }
}