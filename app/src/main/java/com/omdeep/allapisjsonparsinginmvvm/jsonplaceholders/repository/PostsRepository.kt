package com.omdeep.allapisjsonparsinginmvvm.jsonplaceholders.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.omdeep.allapisjsonparsinginmvvm.jsonplaceholders.model.APIEndPoints
import com.omdeep.allapisjsonparsinginmvvm.jsonplaceholders.model.PostData
import com.omdeep.allapisjsonparsinginmvvm.jsonplaceholders.model.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PostsRepository(application: Application) {

    private val mutableLiveData = MutableLiveData<MutableList<PostData>>()
    private val isLoading = MutableLiveData<Boolean>()


    fun getPostsDataInRepo(): MutableLiveData<MutableList<PostData>> {
        isLoading.postValue(true)
        val apiName: APIEndPoints = RetrofitInstance.getInstance(APIEndPoints::class.java)
        apiName.getPostsData()?.enqueue(object : Callback<MutableList<PostData?>?> {

            override fun onResponse(
                call: Call<MutableList<PostData?>?>,
                response: Response<MutableList<PostData?>?>
            ) {
                isLoading.postValue(false)
//                mutableLiveData.postValue(response.body()?.get(PostData))
            }

            override fun onFailure(call: Call<MutableList<PostData?>?>, t: Throwable) {
                isLoading.postValue(false)
            }
        })
        return mutableLiveData
    }

    fun getIsLoading(): MutableLiveData<Boolean> {
        return isLoading
    }
}