package com.nivesh.production.bajajfd.api

import com.nivesh.production.bajajfd.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object{
        private val retrofit by  lazy {
            //lazy means  we only initialize this here once
            val logging=HttpLoggingInterceptor()
            //loggingInterceptor use for  see making request and for see what responses are
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            //see the body of  response
            //create client for  retrofit
            val  client=OkHttpClient.Builder()
                .addInterceptor(logging)
                .retryOnConnectionFailure(true)
                .build()
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
    }
}