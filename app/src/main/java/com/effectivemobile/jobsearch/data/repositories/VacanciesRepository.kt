package com.effectivemobile.jobsearch.data.repositories

import com.effectivemobile.jobsearch.data.Vacancy
import com.effectivemobile.jobsearch.network.VacancyService

interface VacanciesRepository{
    suspend fun getVacancies(id: String, export: String): List<Vacancy>
}

class NetworkVacanciesRepository(
    private val vacancyService: VacancyService
): VacanciesRepository {
    override suspend fun getVacancies(
        id: String,
        export: String
    ): List<Vacancy> = vacancyService.vacancySearch(id, export).vacancies.map {vacancies ->
        Vacancy(
            id = vacancies.id,
            lookingNumber = vacancies.lookingNumber,
            title = vacancies.title,
            address = vacancies.address,
            company = vacancies.company,
            experience = vacancies.experience,
            publishedDate = vacancies.publishedDate,
            isFavorite = vacancies.isFavorite,
            salary = vacancies.salary,
            schedules = vacancies.schedules,
            appliesNumber =  vacancies.appliedNumber,
            description = vacancies.description,
            responsibilities = vacancies.responsibilities,
            questions = vacancies.questions
        )
    }

}