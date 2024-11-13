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
//        welcomeMessage.text = "Welcome, $username!"
        welcomeMessage.text = "Welcome, User"


        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.cricket_scores_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Create dummy data
//        val cricketMatches = List(20) { index ->
//            CricketMatch(
//                team1 = "Team A $index",
//                team2 = "Team B $index",
//                team1Score = (100..200).random().toString(),
//                team2Score = (100..200).random().toString(),
//                winner = if (index % 2 == 0) "Team A" else "Team B"
//            )
//        }
        val cricketMatches = listOf(
            CricketMatch(
                team1 = "Team A 1",
                team2 = "Team B 1",
                team1Score = "150",
                team2Score = "145",
                winner = "Team A 1"
            ),
            CricketMatch(
                team1 = "Team A 2",
                team2 = "Team B 2",
                team1Score = "160",
                team2Score = "155",
                winner = "Team A 2"
            ),
            CricketMatch(
                team1 = "Team A 3",
                team2 = "Team B 3",
                team1Score = "140",
                team2Score = "150",
                winner = "Team B 3"
            ),
            // Add more CricketMatch instances as needed
        )


        // Set up RecyclerView adapter
        val adapter = CricketScoresAdapter(cricketMatches)
        recyclerView.adapter = adapter

        // Bottom Navigation Bar setup
        setupBottomNavigationBar()

        // Handle Logout button click
        val logoutButton: Button = findViewById(R.id.logout_button)
        logoutButton.setOnClickListener {
            handleLogout()
        }
    }

    private fun setupBottomNavigationBar() {
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Already in Home, do nothing
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

    private fun handleLogout() {
        // Clear the login state
        val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isLoggedIn", false)  // Set login state to false
        editor.apply()

        // Navigate to LoginActivity
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
