package com.example.rickandmortynocompose.ui

import com.example.rickandmortynocompose.data.RikyItemResponse


sealed interface ImagesUiStates {
    //object si no recibe datos, data class si sí los recibe
    object Loading:ImagesUiStates
    data class Error(val throwable: Throwable): ImagesUiStates
    data class Success(val imagesList: List<RikyItemResponse>):ImagesUiStates
}
