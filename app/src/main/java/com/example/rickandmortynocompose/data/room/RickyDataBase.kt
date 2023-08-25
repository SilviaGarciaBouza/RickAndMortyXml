package com.example.rickandmortynocompose.data.room



import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmortynocompose.data.RikyItemResponse

@Database(entities = [RikyItemResponse::class], version = 1)
abstract class RickyDataBase: RoomDatabase() {
    abstract fun taskDao(): RickyDao
}