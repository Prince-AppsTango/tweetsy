package com.app.tweetsy.repository

import android.util.Log
import com.app.tweetsy.api.TweetsyApi
import com.app.tweetsy.models.Tweet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyApi: TweetsyApi) {
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
        get() =_categories

    private val _tweets= MutableStateFlow<List<Tweet>>(emptyList())
    val tweets: StateFlow<List<Tweet>>
        get() =  _tweets
    suspend fun getCategories() {
        val response = tweetsyApi.getCategories()
        if (response.isSuccessful && response.body() != null) {
                _categories.emit(response.body()!!.distinct())
        }
    }

    suspend fun getTweets(category: String){
        val response = tweetsyApi.getTweets("tweets[?(@.category==\"$category\")]");
        Log.d("response>>>>>>", "${response.body()}")
        if(response.isSuccessful && response.body() != null){
            _tweets.emit(response.body()!!)
        }
    }
}
