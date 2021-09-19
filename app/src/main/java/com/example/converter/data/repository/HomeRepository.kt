package com.example.converter.data.repository

import com.example.converter.data.Answer
import io.reactivex.rxjava3.core.Single

interface HomeRepository {
    fun getAnswer(): Single<Answer>
    fun updateAnswer(): Single<Answer>
}