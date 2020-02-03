package com.example.asyst.respositories

import com.example.asyst.database.daos.BookDao
import com.example.asyst.database.daos.StudentDao
import com.example.asyst.database.entities.BookEntity
import com.example.asyst.database.entities.StudentEntity

class BookRepository(private val bookDao: BookDao) {
    
    suspend fun addBook(bookEntity: BookEntity) {
        return bookDao.insert(bookEntity)
    }
}