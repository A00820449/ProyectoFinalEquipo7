package com.example.proyectofinalequipo7

import androidx.room.TypeConverter
import java.util.*

class Converters {

    @TypeConverter
    fun longToDate(long: Long?) : Date? {
        return long?.let { Date(it) }
    }

    @TypeConverter
    fun dateToLong(date: Date?) : Long? {
        return date?.time
    }
}