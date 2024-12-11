package com.app.tweetsy.api

import com.app.tweetsy.models.Tweet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {
    @GET("/v3/b/6757dfaee41b4d34e462d426?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String) : Response<List<Tweet>>

    @GET("/v3/b/6757dfaee41b4d34e462d426?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun  getCategories(): Response<List<String>>

}