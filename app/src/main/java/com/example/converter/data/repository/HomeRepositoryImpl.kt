package com.example.converter.data.repository

import com.example.converter.data.Answer
import com.example.converter.data.cache.HomeCache
import com.example.converter.domain.entity.CurrencyDto
import com.example.converter.data.dto.JsonResponseDto
import com.example.converter.data.remote.HomeRemoteSource
import io.reactivex.rxjava3.core.Single
import java.util.*
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeCache: HomeCache,
    private val homeRemoteSource: HomeRemoteSource
) : HomeRepository {

    override fun getAnswer(): Single<Answer> {
        return homeCache.getHomeCache().flatMap {
            if (it is Answer.Success) {
                Single.just(it)
            }
            else getDataToCacheFromRemote()
        }
    }

    override fun updateAnswer(): Single<Answer> {
        homeCache.setJsonResponse(
            JsonResponseDto(
                date = Calendar.getInstance().time,
                previousDate = Calendar.getInstance().time,
                timestamp = Calendar.getInstance().time,
                currenciesList = mapOf(
                    "String" to CurrencyDto(
                        1, "", "", 2, "3", 1.0, 1.3
                    )
                )
            )
        )
        return getDataToCacheFromRemote()
    }

    private fun getDataToCacheFromRemote(): Single<Answer> {
        return homeRemoteSource.getJsonResponseDto()
            .map { homeCache.setJsonResponse(it) }
            .flatMap { homeCache.getHomeCache() }
    }
}