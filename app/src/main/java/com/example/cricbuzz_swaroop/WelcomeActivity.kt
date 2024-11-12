package com.example.cricbuzz_swaroop

import CricketMatch
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class WelcomeActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val username = intent.getStringExtra("username")
        val welcomeMessage: TextView = findViewById(R.id.welcome_message)
        welcomeMessage.text = "Welcome, $username!"

        // Initialize logout button
        val logoutButton: Button = findViewById(R.id.logout_button)
        logoutButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn", false)
            editor.apply()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.cricket_scores_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create dummy data
        val cricketMatches = List(20) { index ->
            CricketMatch(
                team1 = "Team A $index",
                team2 = "Team B $index",
                team1Score = (100..200).random().toString(),
                team2Score = (100..200).random().toString(),
                winner = if (index % 2 == 0) "Team A" else "Team B"
            )
        }

        // Set up RecyclerView adapter
        val adapter = CricketScoresAdapter(cricketMatches)
        recyclerView.adapter = adapter

        // Handle Bottom Navigation Item Clicks
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Stay in the current activity (Welcome Activity)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_more -> {
                    // Navigate to More Activity
                    val intent = Intent(this, MoreActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_news -> {
                    // Navigate to News Activity
                    val intent = Intent(this, NewsActivity::class.java)
                    startActivity(intent)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }
}
