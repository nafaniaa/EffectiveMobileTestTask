package com.effectivemobile.jobsearch.network.models

import com.google.gson.annotations.SerializedName


data class JobSearch (

  @SerializedName("offers"    ) var offers    : ArrayList<Offers>    = arrayListOf(),
  @SerializedName("vacancies" ) var vacancies : ArrayList<Vacancies> = arrayListOf()

)