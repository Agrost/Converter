package com.example.converter.data.dto

import com.example.converter.domain.entity.CurrencyDto
import com.google.gson.annotations.SerializedName
import java.util.*

data class JsonResponseDto(
    @SerializedName("Date")
    private val date: Date,

    @SerializedName("PreviousDate")
    private val previousDate: Date,

    @SerializedName("Timestamp")
    private val timestamp: Date,

    @SerializedName("Valute")
    val currenciesList: Map<String, CurrencyDto>,
)
