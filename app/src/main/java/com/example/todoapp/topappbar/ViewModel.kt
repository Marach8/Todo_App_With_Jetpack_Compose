package com.example.todoapp.topappbar

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){
    private val _searchWidgetState: MutableState<SearchWidgetState>
        = mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState = _searchWidgetState

    private val _searchTextState: MutableState<String>
        = mutableStateOf(value = "")
    val searchTextState = _searchTextState

    fun updateSearchWidgetState(newState: SearchWidgetState){
        _searchWidgetState.value = newState
    }

    fun updateSearchTextState(newState: String){
        _searchTextState.value = newState
    }
}