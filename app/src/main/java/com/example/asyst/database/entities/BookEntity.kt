package com.example.asyst.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class BookEntity (
    @PrimaryKey
    @ColumnInfo(name = "book_id")
    val bookId: Long,

    val name: String
)