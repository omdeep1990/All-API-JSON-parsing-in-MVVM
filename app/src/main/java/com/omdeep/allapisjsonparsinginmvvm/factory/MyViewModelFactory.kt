package com.omdeep.allapisjsonparsinginmvvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.omdeep.allapisjsonparsinginmvvm.repository.MovieRepository
import com.omdeep.allapisjsonparsinginmvvm.viewModel.MainViewModel
import java.lang.IllegalArgumentException

class MyViewModelFactory constructor(private val repository: MovieRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("ViewModel Not Found!!")
    }
}