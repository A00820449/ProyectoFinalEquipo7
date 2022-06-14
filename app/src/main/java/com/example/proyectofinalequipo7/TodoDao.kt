package com.example.proyectofinalequipo7

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    suspend fun getAllTodos() : List<Todo>

    @Query("SELECT * FROM Todo WHERE due_date IS NULL ORDER BY due_date")
    suspend fun getTodosWithNoDueDate() : List<Todo>

    @Query("SELECT * FROM Todo WHERE due_date <= :date ORDER BY due_date")
    suspend fun getTodosWithDueDateBefore(date: Date) : List<Todo>

    @Query("SELECT * FROM Todo WHERE due_date > :date ORDER BY due_date")
    suspend fun getTodosWithDueDateAfter(date: Date) : List<Todo>

    @Query("SELECT * FROM Todo WHERE due_date > :after_date AND due_date <= :before_date ORDER BY due_date")
    suspend fun getTodosWithDueDateBetween(after_date: Date, before_date : Date) : List<Todo>

    @Insert
    suspend fun insertTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)

    @Query("DELETE FROM Todo WHERE id = :id")
    suspend fun deleteTodoById(id : Int)
}