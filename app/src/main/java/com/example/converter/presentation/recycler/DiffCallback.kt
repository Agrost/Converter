package com.example.converter.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.converter.domain.entity.CurrencyDto

class DiffCallback(oldList: List<CurrencyDto>, newList: List<CurrencyDto>) : DiffUtil.Callback() {
    private val oldList = oldList.toList()
    private val newList = newList.toList()
    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldCard: Int, newCard: Int): Boolean {
        return oldList[oldCard].id == newList[newCard].id
    }

    override fun areContentsTheSame(oldCard: Int, newCard: Int): Boolean {
        return oldList[oldCard] == newList[newCard]
    }
}