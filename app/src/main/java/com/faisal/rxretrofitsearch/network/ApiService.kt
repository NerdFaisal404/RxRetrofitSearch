package com.faisal.rxretrofitsearch.network

import com.faisal.rxretrofitsearch.model.Contact
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("contacts.php")
    fun getContacts(@Query("source") source: String, @Query("search") search: String): Single<List<Contact>>

}