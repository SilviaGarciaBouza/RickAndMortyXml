package com.example.rickandmortynocompose.data.room



import androidx.room.Dao
import androidx.room.*
import com.example.rickandmortynocompose.data.RikyItemResponse
import kotlinx.coroutines.flow.Flow


@Dao
public interface RickyDao {
    //Genera la lista de tareas
    @Query("SELECT * from RikyItemResponse")
    fun getTasks(): Flow<List<RikyItemResponse>>
}
