package com.effectivemobile.jobsearch.data

import com.effectivemobile.jobsearch.data.repositories.NetworkVacanciesRepository
import com.effectivemobile.jobsearch.data.repositories.VacanciesRepository
import com.effectivemobile.jobsearch.network.VacancyService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface AppContainer {
    val vacanciesRepository: VacanciesRepository
}

class DefaultAppContainer : AppContainer{
    private val BASE_URL = "https://drive.usercontent.google.com"
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: VacancyService by lazy {
        retrofit.create(VacancyService::class.java)
    }

    override val vacanciesRepository: VacanciesRepository by lazy {
        NetworkVacanciesRepository(retrofitService)
    }
}