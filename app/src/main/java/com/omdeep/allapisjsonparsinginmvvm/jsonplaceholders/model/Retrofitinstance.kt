package com.omdeep.allapisjsonparsinginmvvm.jsonplaceholders.model

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
        //TODO: Another method making retrofit instance with a little change
        fun <S> getInstance(serviceClass: Class<S>?) : S {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
            return retrofit.create(serviceClass)
        }
    }
}