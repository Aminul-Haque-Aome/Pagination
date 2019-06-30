package com.remotearth.fake_coder.pagination.api

import com.remotearth.fake_coder.pagination.pojos.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {

    @GET("posts")
    fun allPosts(): Observable<List<Post>>
}