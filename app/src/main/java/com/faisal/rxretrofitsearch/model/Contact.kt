package com.faisal.rxretrofitsearch.model

import com.google.gson.annotations.SerializedName

data class Contact(@SerializedName("image") val profileImage: String, val name: String, val email: String)