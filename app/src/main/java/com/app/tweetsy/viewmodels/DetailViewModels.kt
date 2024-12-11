package com.app.tweetsy.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.tweetsy.models.Tweet
import com.app.tweetsy.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModels @Inject constructor(private val tweetRepository: TweetRepository,private val savedStateHandle:SavedStateHandle) : ViewModel() {
    val tweets: StateFlow<List<Tweet>> = tweetRepository.tweets

    init {
        viewModelScope.launch {
            val category = savedStateHandle.get<String>("category")
            tweetRepository.getTweets(category?:"android")
        }
    }

}