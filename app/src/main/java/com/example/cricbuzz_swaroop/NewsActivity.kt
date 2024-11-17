package com.example.cricbuzz_swaroop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        // Bottom Navigation Bar setup
        setupBottomNavigationBar()

        // RecyclerView setup
        setupRecyclerView()
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
                    // Already in News, do nothing
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

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Dummy data
        val newsList = listOf(
            NewsItem(R.drawable.img1, "News Title 1", "Description for News Title 1"),
            NewsItem(R.drawable.img1, "News Title 2", "Description for News Title 2"),
            NewsItem(R.drawable.img1, "News Title 3", "Description for News Title 3"),
            NewsItem(R.drawable.img1, "News Title 4", "Description for News Title 4"),
            NewsItem(R.drawable.img1, "News Title 5", "Description for News Title 5"),
            NewsItem(R.drawable.img1, "News Title 6", "Description for News Title 6"),
            NewsItem(R.drawable.img1, "News Title 7", "Description for News Title 7"),
            NewsItem(R.drawable.img1, "News Title 8", "Description for News Title 8"),
            NewsItem(R.drawable.img1, "News Title 9", "Description for News Title 9"),
            NewsItem(R.drawable.img1, "News Title 10", "Description for News Title 10")
        )

        val adapter = NewsAdapter(newsList)
        recyclerView.adapter = adapter
    }
}
