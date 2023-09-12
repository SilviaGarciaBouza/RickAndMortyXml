package com.example.rickandmortynocompose.data


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitCLient {
    //Segunda parte de la url empezando con /
    @GET(value= "/api/character")

    //En hilo secundario. Devuelve un response del tipo de datos retrofitResponse
    suspend fun doListRikyItems():Response<RetrofitResponse>

   @GET(value = "/api/character/{id}")
    suspend fun getCharacter(@Path("id") characterId: Int): Response<RikyItemResponse>

}