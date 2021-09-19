package com.example.converter.data.cache

import com.example.converter.data.Answer
import com.example.converter.data.dto.JsonResponseDto
import io.reactivex.rxjava3.core.Single

interface HomeCache {
    fun getHomeCache(): Single<Answer>
    fun setJsonResponse(jsonResponse: JsonResponseDto)
}