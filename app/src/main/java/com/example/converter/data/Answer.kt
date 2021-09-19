package com.example.converter.data

import com.example.converter.data.dto.JsonResponseDto
sealed class Answer {
    class Success(
        val jsonResponseDto: JsonResponseDto
        ) : Answer()
    object Failure : Answer()
    object Loading : Answer()
}