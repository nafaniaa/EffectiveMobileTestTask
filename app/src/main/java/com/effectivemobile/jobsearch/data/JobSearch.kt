package com.effectivemobile.jobsearch.data

import com.google.gson.annotations.SerializedName

data class JobSearch(
    @SerializedName("vacancies") val vacancies: List<Vacancy>
)