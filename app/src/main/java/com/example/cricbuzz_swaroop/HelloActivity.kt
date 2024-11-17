package com.example.cricbuzz_swaroop

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val helloTextView: TextView = findViewById(R.id.hello_text_view)
        helloTextView.text = "India won by 11 runs"

        // Bottom Navigation Bar setup
        setupBottomNavigationBar()

        // Sample data
        val players = listOf(
            Player("Samson (wk)", "b Marco Jansen", 0, 2, 0, 0, 0f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f),

            // Add more players here
        )
        val secondTeamPlayers = listOf(
            Player("Samson (wk)", "b Marco Jansen", 0, 2, 0, 0, 0f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f),
            Player("Abhishek Sharma", "st Klaasen b Maharaj", 50, 25, 3, 5, 200f)

            // Add more players here
        )

        // Find ListView and set the adapter
        val listView: ListView = findViewById(R.id.team2_score_list)
        val adapter = PlayerAdapter(this, players)
        listView.adapter = adapter

        val secondListView: ListView = findViewById(R.id.team22_score_list)
        val secondAdapter = PlayerAdapter(this, secondTeamPlayers)
        secondListView.adapter = secondAdapter
    }

    private fun setupBottomNavigationBar() {
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, WelcomeActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.nav_news -> {
                    val intent = Intent(this, NewsActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.nav_more -> {
                    val intent = Intent(this, MoreActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                else -> false
            }
        }
    }
}
