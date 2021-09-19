package com.example.converter.presentation.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.converter.R
import com.example.converter.domain.entity.CurrencyDto
import java.text.DecimalFormat

class RecyclerAdapter(
    val fragmentTransaction: (CurrencyDto) -> Unit
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var items: List<CurrencyDto> = listOf()
        set(value) {
            val callback = DiffCallback(field, value)
            field = value
            DiffUtil.calculateDiff(callback).dispatchUpdatesTo(this)
        }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currencyName: TextView = itemView.findViewById(R.id.сurrency_name)
        var currencyValue: TextView = itemView.findViewById(R.id.сurrency_value)
        var viewHolder: CardView = itemView.findViewById(R.id.item_view_holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.currency_card, parent, false)
        )
    }

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewHolder.setOnClickListener {
            fragmentTransaction(items[position])
        }
        holder.currencyName.text = items[position].name
        holder.currencyValue.text = DecimalFormat("#0.0000").format(items[position].value)
    }

}
