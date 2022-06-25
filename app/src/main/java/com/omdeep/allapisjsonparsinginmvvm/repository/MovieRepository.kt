package com.omdeep.allapisjsonparsinginmvvm.repository

import com.omdeep.allapisjsonparsinginmvvm.retrofitService.RetrofitService

class MovieRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllMovies() = retrofitService.getAllMovies()
}