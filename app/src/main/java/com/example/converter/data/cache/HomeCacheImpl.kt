package com.example.converter.data.cache

import com.example.converter.data.Answer
import com.example.converter.data.dto.JsonResponseDto
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class HomeCacheImpl @Inject constructor() : HomeCache {

    private var _jsonResponseDto: JsonResponseDto? = null

    override fun getHomeCache(): Single<Answer> {
        if (_jsonResponseDto == null) {
            return Single.just(Answer.Failure)
        }
        return Single.just(Answer.Success(_jsonResponseDto!!))
    }

    override fun setJsonResponse(jsonResponse: JsonResponseDto) {
        _jsonResponseDto = jsonResponse
    }
}