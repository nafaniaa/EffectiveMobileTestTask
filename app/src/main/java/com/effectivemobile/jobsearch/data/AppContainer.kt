package com.effectivemobile.jobsearch.data

import com.effectivemobile.jobsearch.data.repositories.NetworkVacanciesRepository
import com.effectivemobile.jobsearch.data.repositories.VacanciesRepository
import com.effectivemobile.jobsearch.network.VacancyService
import com.effectivemobile.jobsearch.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface AppContainer {
    val vacanciesRepository: VacanciesRepository
}

class DefaultAppContainer : AppContainer{

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitService: VacancyService by lazy {
        retrofit.create(VacancyService::class.java)
    }

    override val vacanciesRepository: VacanciesRepository by lazy {
        NetworkVacanciesRepository(retrofitService)
    }
}