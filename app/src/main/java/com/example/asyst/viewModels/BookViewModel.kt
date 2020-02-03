package com.example.asyst.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.asyst.database.AppDatabase
import com.example.asyst.respositories.BookRepository

class BookViewModel(application: Application): AndroidViewModel(application) {
    private val bookRepository: BookRepository

    init {
        val bookDao = AppDatabase.getInstance(application).bookDao()
        bookRepository = BookRepository(bookDao)
    }
}