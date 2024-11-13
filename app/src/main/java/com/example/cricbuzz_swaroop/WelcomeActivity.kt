package com.example.cricbuzz_swaroop

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
        welcomeMessage.text = "Welcome, User"

        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.cricket_scores_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Updated list with new data structure
        val cricketMatches = listOf(
            CricketMatch(
                trophyName = "ICC World Cup",
                matchName = "Final Match",
                team1 = "India",
                team2 = "Australia",
                team1Score = "250/8",
                team2Score = "230/10",
                winner = "India",
                team1Flag = R.drawable.india_flag,  // Replace with actual flag resource
                team2Flag = R.drawable.australia_flag // Replace with actual flag resource
            ),
            CricketMatch(
                trophyName = "T20 World Cup",
                matchName = "Group Stage",
                team1 = "England",
                team2 = "South Africa",
                team1Score = "180/5",
                team2Score = "170/8",
                winner = "England",
                team1Flag = R.drawable.england_flag,  // Replace with actual flag resource
                team2Flag = R.drawable.south_africa_flag // Replace with actual flag resource
            ),
            CricketMatch(
                trophyName = "Asia Cup",
                matchName = "Quarter Final",
                team1 = "Sri Lanka",
                team2 = "Pakistan",
                team1Score = "160/4",
                team2Score = "150/7",
                winner = "Sri Lanka",
                team1Flag = R.drawable.sri_lanka_flag,  // Replace with actual flag resource
                team2Flag = R.drawable.pakistan_flag // Replace with actual flag resource
            ),
            // Add more CricketMatch instances as needed
            CricketMatch(
                trophyName = "ICC World Cup",
                matchName = "Final Match",
                team1 = "India",
                team2 = "Australia",
                team1Score = "250/8",
                team2Score = "230/10",
                winner = "India",
                team1Flag = R.drawable.india_flag,  // Replace with actual flag resource
                team2Flag = R.drawable.australia_flag // Replace with actual flag resource
            ),
            CricketMatch(
                trophyName = "ICC World Cup",
                matchName = "Final Match",
                team1 = "India",
                team2 = "Australia",
                team1Score = "250/8",
                team2Score = "230/10",
                winner = "India",
                team1Flag = R.drawable.india_flag,  // Replace with actual flag resource
                team2Flag = R.drawable.australia_flag // Replace with actual flag resource
            ),
            CricketMatch(
                trophyName = "ICC World Cup",
                matchName = "Final Match",
                team1 = "India",
                team2 = "Australia",
                team1Score = "250/8",
                team2Score = "230/10",
                winner = "India",
                team1Flag = R.drawable.india_flag,  // Replace with actual flag resource
                team2Flag = R.drawable.australia_flag // Replace with actual flag resource
            ),
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
