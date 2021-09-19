package com.example.converter.data.remote

import com.example.converter.data.Api
import com.example.converter.data.dto.JsonResponseDto
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class HomeRemoteSourceImpl @Inject constructor(
    private val api: Api
) : HomeRemoteSource {
    override fun getJsonResponseDto(): Single<JsonResponseDto> {
        return api.getJsonResponse()
    }
}