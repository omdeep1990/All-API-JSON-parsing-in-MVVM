package com.omdeep.allapisjsonparsinginmvvm.retrofitService
import com.omdeep.allapisjsonparsinginmvvm.model.MovieList
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    //TODO: Always use the Call of retrofit2
    @GET("api?s=batman")
    fun getAllMovies() : Call<MovieList>

    //TODO: Companion object for fetching Retrofit function members
    companion object {
        var retrofitService : RetrofitService? =null
        const val BASE_URL = "https://fake-movie-database-api.herokuapp.com/"

        //TODO: Creating retrofit service instance using the retrofit
        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}