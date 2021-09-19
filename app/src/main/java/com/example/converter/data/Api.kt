package com.example.converter.data

import com.example.converter.data.dto.JsonResponseDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface Api {

    @GET("daily_json.js")
    fun getJsonResponse(): Single<JsonResponseDto>
}