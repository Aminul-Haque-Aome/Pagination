package com.remotearth.fake_coder.pagination.api

import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("posts")
    fun allPosts(): Call<APIResponse>
}