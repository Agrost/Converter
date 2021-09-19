package com.example.converter.domain.usecase

import com.example.converter.data.repository.HomeRepository
import javax.inject.Inject

class GetHomeUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    fun getAnswer() = homeRepository.getAnswer()

    fun updateAnswer() = homeRepository.updateAnswer()
}