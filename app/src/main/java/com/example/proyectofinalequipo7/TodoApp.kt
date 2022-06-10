package com.example.proyectofinalequipo7

import android.app.Application

class TodoApp : Application() {
    val database : AppDatabase by lazy { AppDatabase.getDatabase(this) }
}