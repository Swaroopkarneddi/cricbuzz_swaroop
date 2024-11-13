package com.example.cricbuzz_swaroop

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CricketScoresAdapter(private val cricketMatches: List<CricketMatch>) :
    RecyclerView.Adapter<CricketScoresAdapter.CricketMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CricketMatchViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cricket_score, parent, false)
        return CricketMatchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CricketMatchViewHolder, position: Int) {
        val match = cricketMatches[position]

        holder.trophyName.text = match.trophyName
        holder.matchName.text = match.matchName
        holder.team1.text = match.team1
        holder.team2.text = match.team2
        holder.team1Score.text = match.team1Score
        holder.team2Score.text = match.team2Score
        holder.winner.text = "${match.winner} won"

        holder.team1Flag.setImageResource(match.team1Flag)  // Set team 1 flag image
        holder.team2Flag.setImageResource(match.team2Flag)  // Set team 2 flag image
    }

    override fun getItemCount(): Int {
        return cricketMatches.size
    }

    inner class CricketMatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val trophyName: TextView = itemView.findViewById(R.id.trophy_name_text_view)
        val matchName: TextView = itemView.findViewById(R.id.match_name_text_view)
        val team1: TextView = itemView.findViewById(R.id.team1_text_view)
        val team2: TextView = itemView.findViewById(R.id.team2_text_view)
        val team1Score: TextView = itemView.findViewById(R.id.team1_score_text_view)
        val team2Score: TextView = itemView.findViewById(R.id.team2_score_text_view)
        val winner: TextView = itemView.findViewById(R.id.winner_text_view)
        val team1Flag: ImageView = itemView.findViewById(R.id.team1_flag_image_view)
        val team2Flag: ImageView = itemView.findViewById(R.id.team2_flag_image_view)
    }
}
