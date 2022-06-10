package com.example.proyectofinalequipo7

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    suspend fun getAllTodos() : List<Todo>

    @Insert
    suspend fun insertTodo(todo: Todo)
}