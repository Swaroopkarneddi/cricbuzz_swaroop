package com.example.cricbuzz_swaroop

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CricketScoresAdapter(
    private val allMatches: List<CricketMatch>, // Original dataset
    private val context: Context
) : RecyclerView.Adapter<CricketScoresAdapter.CricketMatchViewHolder>() {

    private val filteredMatches = allMatches.toMutableList() // Mutable list for filtered data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CricketMatchViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cricket_score, parent, false)
        return CricketMatchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CricketMatchViewHolder, position: Int) {
        val match = filteredMatches[position]
        holder.trophyName.text = match.trophyName
        holder.matchName.text = match.matchName
        holder.team1.text = match.team1
        holder.team2.text = match.team2
        holder.team1Score.text = match.team1Score
        holder.team2Score.text = match.team2Score
        holder.winner.text = "${match.winner} won"
        holder.team1Flag.setImageResource(match.team1Flag)
        holder.team2Flag.setImageResource(match.team2Flag)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, HelloActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return filteredMatches.size
    }

    // Filter logic
    fun filter(category: String) {
        filteredMatches.clear()
        if (category == "All") {
            filteredMatches.addAll(allMatches)
        } else {
            filteredMatches.addAll(allMatches.filter { it.category == category })
        }
        notifyDataSetChanged() // Refresh RecyclerView
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

