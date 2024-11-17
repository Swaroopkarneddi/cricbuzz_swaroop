package com.example.cricbuzz_swaroop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PlayerAdapter(private val context: Context, private val dataSource: List<Player>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = convertView ?: inflater.inflate(R.layout.item_score, parent, false)

        val playerNameTextView = rowView.findViewById<TextView>(R.id.player_name)
        val playerDescriptionTextView = rowView.findViewById<TextView>(R.id.player_description)
        val playerRunsTextView = rowView.findViewById<TextView>(R.id.player_runs)
        val playerBallsTextView = rowView.findViewById<TextView>(R.id.player_balls)
        val playerFoursTextView = rowView.findViewById<TextView>(R.id.player_fours)
        val playerSixesTextView = rowView.findViewById<TextView>(R.id.player_sixes)
        val playerSrTextView = rowView.findViewById<TextView>(R.id.player_sr)

        val player = getItem(position) as Player

        playerNameTextView.text = player.name
        playerDescriptionTextView.text = player.description
        playerRunsTextView.text = player.runs.toString()
        playerBallsTextView.text = player.balls.toString()
        playerFoursTextView.text = player.fours.toString()
        playerSixesTextView.text = player.sixes.toString()
        playerSrTextView.text = player.strikeRate.toString()

        return rowView
    }
}
