package com.c16.flywithme.presentation.ui.user.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.c16.flywithme.R
import com.c16.flywithme.data.response.HistoryResponse

class AdapterHistories(private val clickListener: OnItemClickListener) : RecyclerView.Adapter<AdapterHistories.ViewHolderHistories>() {

    var historiesList = mutableListOf<HistoryResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHistories {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_row_list_histories, parent, false)
        return ViewHolderHistories(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolderHistories, position: Int) {
        holder.bin(historiesList[position])
        holder.itemView.setOnClickListener {
            clickListener.onItemDetailCLick(historiesList[position])
        }
    }

    override fun getItemCount(): Int = historiesList.size

    class ViewHolderHistories( view: View) : RecyclerView.ViewHolder(view){
        val tvTypeOfClass = view.findViewById<TextView>(R.id.tv_typeOfClass)
        val tvFrom = view.findViewById<TextView>(R.id.tv_from)
        val tvTo = view.findViewById<TextView>(R.id.tv_to)

        fun bin(histories: HistoryResponse){
            tvTypeOfClass.text = histories.orderList[0].flight.typeOfClass
            tvFrom.text = histories.orderList[0].flight.from
            tvTo.text = histories.orderList[0].flight.to
        }
    }

    interface OnItemClickListener {
        fun onItemDetailCLick(flight : HistoryResponse)
    }
}