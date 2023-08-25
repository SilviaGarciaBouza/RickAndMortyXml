package com.example.rickandmortynocompose.domain

import com.example.rickandmortynocompose.data.RickRepository
import com.example.rickandmortynocompose.data.RikyItemResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject



class GetFlowRickyListUseCase @Inject constructor(private val repository: RickRepository) {
    operator fun invoke(): Flow<List<RikyItemResponse>> {
        return repository.getListRickAndMorty
    }
}