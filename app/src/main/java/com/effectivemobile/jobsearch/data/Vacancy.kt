package com.effectivemobile.jobsearch.data

import com.effectivemobile.jobsearch.network.models.Address
import com.effectivemobile.jobsearch.network.models.Experience
import com.effectivemobile.jobsearch.network.models.Salary
import com.google.gson.annotations.SerializedName

data class Vacancy(
    @SerializedName("id")val id: String?,
    @SerializedName("lookingNumber") val lookingNumber: Int?,
    @SerializedName("title")val title: String?,
    @SerializedName("address")val address: Address?,
    @SerializedName("company")val company: String?,
    @SerializedName("experience")val experience: Experience?,
    @SerializedName("publishedData")val publishedDate: String?,
    @SerializedName("isFavorite") var isFavorite: Boolean?,
    @SerializedName("salary")val salary: Salary?,
    @SerializedName("schedules")val schedules: ArrayList<String>,
    @SerializedName("appliesNumber")val appliesNumber: Int?,
    @SerializedName("description")val description: String?,
    @SerializedName("responsibilities")val responsibilities: String?,
    @SerializedName("questions")val questions: ArrayList<String>
)
