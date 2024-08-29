package com.effectivemobile.jobsearch.data

import com.effectivemobile.jobsearch.network.models.Address
import com.effectivemobile.jobsearch.network.models.Experience
import com.effectivemobile.jobsearch.network.models.Salary

data class Vacancy(
    val id: String?,
    val lookingNumber: Int?,
    val title: String?,
    val address: Address?,
    val company: String?,
    val experience: Experience?,
    val publishedDate: String?,
    val isFavorite: Boolean?,
    val salary: Salary?,
    val schedules: ArrayList<String>,
    val appliesNumber: Int?,
    val description: String?,
    val responsibilities: String?,
    val questions: ArrayList<String>
)
