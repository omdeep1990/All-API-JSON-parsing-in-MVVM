package com.omdeep.allapisjsonparsinginmvvm.jsonplaceholders.model

import retrofit2.Call
import retrofit2.http.GET

interface APIEndPoints {

    @GET("/posts")
    open fun getPostsData(): Call<MutableList<PostData?>?>?

//    @GET("/comments")
//    open fun getCommentData() : Call<MutableList<CommentData?>?>?
//
//    @GET("/albums")
//    open fun getAlbumsData() : Call<MutableList<AlbumData?>?>?
//
//    @GET("/todos")
//    open fun getToDoData() : Call<MutableList<ToDoData?>?>?
//
//    @GET("/users")
//    open fun getUsersData() : Call<MutableList<UsersData?>?>?

}