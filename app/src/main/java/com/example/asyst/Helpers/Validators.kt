package com.example.asyst.Helpers

object Validators {
    fun required(value: String): Boolean {
        return value.trim().isNotBlank()
    }
}