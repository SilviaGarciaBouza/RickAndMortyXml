package com.example.rickandmortynocompose.ui



import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.example.rickandmortynocompose.data.RikyItemResponse
import com.example.rickandmortynocompose.domain.DoListRikyListUseCase
import com.example.rickandmortynocompose.domain.GetFlowRickyListUseCase
//import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import com.example.rickandmortynocompose.R
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.rickandmortynocompose.ui.ImagesUiStates.MySuccess
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch






@HiltViewModel
class RikyViewModel @Inject constructor(
    private val doListRikyListUseCase: DoListRikyListUseCase,
    private val getFlowRickyListUseCase: GetFlowRickyListUseCase
) : ViewModel() {


    //Obtén la lista:
    fun callList(): List<RikyItemResponse> {
        return runBlocking { doListRikyListUseCase() }
    }

    //llama al flow
    val usiState: StateFlow<ImagesUiStates> = getFlowRickyListUseCase().map( ::MySuccess )
        .catch { ImagesUiStates.Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ImagesUiStates.Loading)

}


