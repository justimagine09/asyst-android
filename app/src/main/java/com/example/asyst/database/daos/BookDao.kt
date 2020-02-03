package com.example.asyst.database.daos

import androidx.room.Dao
import androidx.room.Insert
import com.example.asyst.database.entities.BookEntity

@Dao
interface BookDao {
    @Insert
    suspend fun insert(bookEntity: BookEntity)
}