package com.example.core.data.database

import androidx.room.TypeConverter
import com.example.core.data.model.Procedure
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DefaultTypeConverter {

    @TypeConverter
    fun fromStringToProcedure(value: String?): Procedure? {
        val type = object : TypeToken<Procedure>() {}.type
        return Gson().fromJson(value, type)
    }

    @TypeConverter
    fun toString(procedure: Procedure?): String? {
        return Gson().toJson(procedure)
    }

}