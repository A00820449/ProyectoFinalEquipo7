package com.example.proyectofinalequipo7

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "title") val title : String,
    @ColumnInfo(name = "body") val body : String?,
    @ColumnInfo(name = "date") val date : Date,
    @ColumnInfo(name = "due_date") val dueDate : Date?,
    @ColumnInfo(name = "done") val done : Boolean = false
)
