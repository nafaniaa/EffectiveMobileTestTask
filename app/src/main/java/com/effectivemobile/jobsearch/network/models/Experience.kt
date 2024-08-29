package com.effectivemobile.jobsearch.network.models

import com.google.gson.annotations.SerializedName


data class Experience (

  @SerializedName("previewText" ) var previewText : String? = null,
  @SerializedName("text"        ) var text        : String? = null

)