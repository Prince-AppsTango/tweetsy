package com.app.tweetsy.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.tweetsy.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModels @Inject constructor(private val tweetRepository: TweetRepository) : ViewModel() {
    val categories: StateFlow<List<String>> = tweetRepository.categories

    init {
        viewModelScope.launch(Dispatchers.IO) {
            tweetRepository.getCategories()
        }
    }

}