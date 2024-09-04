package com.effectivemobile.jobsearch.ui.viewModels

import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.effectivemobile.jobsearch.JobSearchApplication
import com.effectivemobile.jobsearch.data.Vacancy
import com.effectivemobile.jobsearch.data.repositories.VacanciesRepository
import com.effectivemobile.jobsearch.utils.Constants
import kotlinx.coroutines.launch
import java.io.IOException


sealed interface VacanciesUiState {
    data class Success(val vacancySearch: List<Vacancy>): VacanciesUiState
    object Error : VacanciesUiState
    object Loading: VacanciesUiState
}

class VacanciesViewModel(
    private val vacanciesRepository: VacanciesRepository
): ViewModel() {
    var vacanciesUiState: VacanciesUiState by mutableStateOf(VacanciesUiState.Loading)
        private set

    init {
        getVacancies()
    }
    fun getVacancies(id: String = Constants.id, export: String = Constants.export){
        viewModelScope.launch {
            vacanciesUiState = VacanciesUiState.Loading
            vacanciesUiState = try{
                VacanciesUiState.Success(vacanciesRepository.getVacancies(id, export))
            } catch (e: IOException){
                VacanciesUiState.Error
            } catch (e: retrofit2.HttpException){
                VacanciesUiState.Error
            }
        }
    }


    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as JobSearchApplication)
                val vacanciesRepository = application.container.vacanciesRepository
                VacanciesViewModel(vacanciesRepository = vacanciesRepository)
            }
        }
    }
}