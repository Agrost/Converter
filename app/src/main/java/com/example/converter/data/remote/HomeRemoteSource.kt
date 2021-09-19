package com.example.converter.data.remote

import com.example.converter.data.dto.JsonResponseDto
import io.reactivex.rxjava3.core.Single

interface HomeRemoteSource {
    fun getJsonResponseDto(): Single<JsonResponseDto>
}