package com.example.cricbuzz_swaroop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Get username from Intent
        val username = intent.getStringExtra("username") ?: "User"
        val welcomeMessage: TextView = findViewById(R.id.welcome_message)
//        welcomeMessage.text = "Welcome, $username"
        welcomeMessage.text = "Welcome, User"


        // Initialize RecyclerView
        setupRecyclerView()

        // Bottom Navigation Bar setup
        setupBottomNavigationBar()

        // Handle Logout button click
        val logoutButton: Button = findViewById(R.id.logout_button)
        logoutButton.setOnClickListener {
            handleLogout()
        }
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.cricket_scores_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val cricketMatches = listOf(
            CricketMatch(
                trophyName = "ICC World Cup",
                matchName = "Final Match",
                team1 = "India",
                team2 = "Australia",
                team1Score = "250/8",
                team2Score = "230/10",
                winner = "India",
                team1Flag = R.drawable.india_flag,
                team2Flag = R.drawable.australia_flag,
                category = "International"
            ),
            CricketMatch(
                trophyName = "ICC World Cup",
                matchName = "Quarter Final",
                team1 = "Australia",
                team2 = "Pakistan",
                team1Score = "160/4",
                team2Score = "150/7",
                winner = "Australia",
                team1Flag = R.drawable.australia_flag,
                team2Flag = R.drawable.pakistan_flag,
                category = "International"
            ),
            CricketMatch(
                trophyName = "T20 World Cup",
                matchName = "Group Stage",
                team1 = "England",
                team2 = "South Africa",
                team1Score = "180/5",
                team2Score = "170/8",
                winner = "England",
                team1Flag = R.drawable.england_flag,
                team2Flag = R.drawable.south_africa_flag,
                category = "T20"
            ),
            CricketMatch(
                trophyName = "Asia Cup",
                matchName = "Quarter Final",
                team1 = "Sri Lanka",
                team2 = "Pakistan",
                team1Score = "160/4",
                team2Score = "150/7",
                winner = "Sri Lanka",
                team1Flag = R.drawable.sri_lanka_flag,
                team2Flag = R.drawable.pakistan_flag,
                category = "ODI"
            ),
            CricketMatch(
                trophyName = "World Cup",
                matchName = "Group Stage",
                team1 = "England",
                team2 = "Sri Lanka",
                team1Score = "180/5",
                team2Score = "170/8",
                winner = "England",
                team1Flag = R.drawable.england_flag,
                team2Flag = R.drawable.sri_lanka_flag,
                category = "ODI"
            ),
        )

        val adapter = CricketScoresAdapter(cricketMatches, this)
        recyclerView.adapter = adapter
        // Set up filter buttons
        val filterAll: Button = findViewById(R.id.filter_all)
        val filterInternational: Button = findViewById(R.id.filter_international)
        val filterODI: Button = findViewById(R.id.filter_odi)
        val filterT20: Button = findViewById(R.id.filter_t20)

        filterAll.setOnClickListener { adapter.filter("All") }
        filterInternational.setOnClickListener { adapter.filter("International") }
        filterODI.setOnClickListener { adapter.filter("ODI") }
        filterT20.setOnClickListener { adapter.filter("T20") }
    }

    private fun setupBottomNavigationBar() {
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true // Already in Home, do nothing
                R.id.nav_news -> {
                    navigateToActivity(NewsActivity::class.java)
                    true
                }
                R.id.nav_more -> {
                    navigateToActivity(MoreActivity::class.java)
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateToActivity(activityClass: Class<*>) {
        val intent = Intent(this, activityClass)
        startActivity(intent)
        finish()
    }

    private fun handleLogout() {
        // Clear login state
        val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
        sharedPreferences.edit().apply {
            putBoolean("isLoggedIn", false)
            apply()
        }

        // Navigate to LoginActivity
        Toast.makeText(this, "Logged out successfully!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
