package com.faisal.rxretrofitsearch.network

import com.faisal.rxretrofitsearch.constant.Const
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


class ApiClient {

    companion object {
        private val TAG = ApiClient::class.java.simpleName
        private var retrofit: Retrofit? = null
        private val REQUEST_TIMEOUT = 60
        private var okHttpClient: OkHttpClient? = null

        fun getClient() : Retrofit{
            if (okHttpClient === null){

                if (retrofit == null){
                    retrofit = Retrofit.Builder()
                            .baseUrl(Const.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build()
                }


            }

            return this!!.retrofit!!
        }

        fun initOkHttp(){
            val httpClient = OkHttpClient().newBuilder()
                    .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .readTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)

            var httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Request-Type", "Android")
                        .addHeader("Content-Type", "application/json")

                val request = requestBuilder.build()
                chain.proceed(request)
            }

            okHttpClient = httpClient.build();
        }

    }

    fun resetApiClient() {
        retrofit = null
        okHttpClient = null
    }
}