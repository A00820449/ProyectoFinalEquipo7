package com.example.proyectofinalequipo7

import java.util.*

data class Todo(
    val id : Int,
    val title : String,
    val body : String?,
    val date : Date,
    val dueDate : Date?
)
