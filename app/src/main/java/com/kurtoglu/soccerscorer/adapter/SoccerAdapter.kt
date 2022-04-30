package com.kurtoglu.soccerscorer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kurtoglu.soccerscorer.R
import com.kurtoglu.soccerscorer.model.SoccerResponse
import kotlinx.android.synthetic.main.row_item_layout.view.*

class SoccerAdapter  : RecyclerView.Adapter<SoccerAdapter.SoccerViewHolder>() {


    private var soccerDataList: ArrayList<SoccerResponse.SoccerResponseItem> = arrayListOf()


    inner class SoccerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(s: SoccerResponse.SoccerResponseItem) {
            itemView.tv_first_team.text = s.firsTeam
            itemView.tv_second_team.text = s.secondTeam
            itemView.time.text = s.dakika
            itemView.tv_result.text = s.macSonucu

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SoccerViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_layout, parent, false)
    )

    override fun onBindViewHolder(holder: SoccerAdapter.SoccerViewHolder, position: Int) {
        holder.bind(soccerDataList[position])

    }


    override fun getItemCount(): Int = soccerDataList.size


    fun setSoccerData(dataSoccer: ArrayList<SoccerResponse.SoccerResponseItem>) {
        soccerDataList.clear()
        soccerDataList.addAll(dataSoccer)
        notifyDataSetChanged()
    }

    fun clear() {
        soccerDataList.clear()
        notifyDataSetChanged()
    }
}