package com.effectivemobile.jobsearch.network

import com.effectivemobile.jobsearch.data.JobSearch
import retrofit2.http.GET
import retrofit2.http.Query

interface VacancyService {
    @GET("u/0/uc")
    suspend fun vacancySearch(
        @Query("id") id: String,
        @Query("export") export: String
    ): JobSearch
}