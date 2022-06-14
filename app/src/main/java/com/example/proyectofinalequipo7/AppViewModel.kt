package com.example.proyectofinalequipo7

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.util.*

class AppViewModel(private val todoDao: TodoDao) : ViewModel() {

    suspend fun getAllTodos() : List<Todo> = todoDao.getAllTodos()

    suspend fun addTodo(todo: Todo) = todoDao.insertTodo(todo)

    suspend fun updateTodo(todo: Todo) = todoDao.updateTodo(todo)

    suspend fun deleteTodo(id : Int) = todoDao.deleteTodoById(id)

    suspend fun getTodosDueBefore(date: Date) = todoDao.getTodosWithDueDateBefore(date)

    suspend fun getTodosDueAfter(date: Date) = todoDao.getTodosWithDueDateAfter(date)

    suspend fun getTodosDueBetween(dateAfter : Date, dateBefore : Date) = todoDao.getTodosWithDueDateBetween(dateAfter, dateBefore)

    suspend fun getTodosNoDue() = todoDao.getTodosWithNoDueDate()
}

class AppViewModelFactory (private val todoDao: TodoDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AppViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AppViewModel(todoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}