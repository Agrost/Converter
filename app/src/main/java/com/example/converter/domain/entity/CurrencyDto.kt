package com.example.converter.domain.entity

import com.google.gson.annotations.SerializedName

data class CurrencyDto(
    @SerializedName("Id")
    val id: Int,

    @SerializedName("NumCode")
    val numCode: String,

    @SerializedName("CharCode")
    val charCode: String,

    @SerializedName("Nominal")
    val nominal: Int,

    @SerializedName("Name")
    val name: String,

    @SerializedName("Value")
    val value: Double,

    @SerializedName("Previous")
    val previous: Double,
)
