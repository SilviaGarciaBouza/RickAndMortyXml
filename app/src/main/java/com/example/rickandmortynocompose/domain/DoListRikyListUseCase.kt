package com.example.rickandmortynocompose.domain


import com.example.rickandmortynocompose.data.RickRepository
import com.example.rickandmortynocompose.data.RikyItemResponse
import javax.inject.Inject


class DoListRikyListUseCase @Inject constructor(private val repository: RickRepository) {

    suspend operator fun invoke(): List<RikyItemResponse> {
//aquí la lógica, la acción pero en este caso solo es si la respuesta es false o true
        return repository.doListRikyItems()
    }
}

