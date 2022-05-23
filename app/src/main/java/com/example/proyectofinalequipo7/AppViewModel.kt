package com.example.proyectofinalequipo7

import androidx.lifecycle.ViewModel
import java.util.*

class AppViewModel : ViewModel() {
    private val _todos = mutableListOf<Todo>()

    val todos get() = _todos

    fun addTodo(title: String, body: String, dueDate : Date?) {
        _todos.add(Todo(0, title, body, Date(), dueDate))
    }
}