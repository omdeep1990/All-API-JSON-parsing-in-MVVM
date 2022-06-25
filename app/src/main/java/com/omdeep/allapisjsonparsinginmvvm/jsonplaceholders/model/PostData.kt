package com.omdeep.allapisjsonparsinginmvvm.jsonplaceholders.model

import androidx.databinding.BaseObservable
import com.google.gson.annotations.SerializedName

class PostData : BaseObservable(){

    @SerializedName("userId")
    private val userId: String? = null

    @SerializedName("id")
    private val id : String? = null

    @SerializedName("title")
    private val title : String? = null

    @SerializedName("body")
    private val body : String? = null
}