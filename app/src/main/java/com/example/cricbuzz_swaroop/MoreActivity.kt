package com.example.cricbuzz_swaroop

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MoreActivity : AppCompatActivity() {

    private lateinit var moreListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        // Bottom Navigation Bar setup
        setupBottomNavigationBar()

        // ListView setup
        setupListView()
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
                    // Already in More, do nothing
                    true
                }
                else -> false
            }
        }
    }

    private fun setupListView() {
        moreListView = findViewById(R.id.more_list_view)

        val moreItemList = listOf(
            MoreItem(R.drawable.logo, "Browse Series"),
            MoreItem(R.drawable.logo, "Browse Teams"),
            MoreItem(R.drawable.logo, "Browse Players"),
            MoreItem(R.drawable.logo, "Schedule"),
            MoreItem(R.drawable.logo, "Archives"),
            MoreItem(R.drawable.logo, "Photos"),
            MoreItem(R.drawable.logo, "Quotes"),
            MoreItem(R.drawable.logo, "ICC Ranking Men"),
            MoreItem(R.drawable.logo, "ICC Ranking Women"),
            MoreItem(R.drawable.logo, "Records"),
            MoreItem(R.drawable.logo, "ICC World Test Championship"),
            MoreItem(R.drawable.logo, "ICC World Super League"),
            MoreItem(R.drawable.logo, "Rate the App"),
            MoreItem(R.drawable.logo, "Feedback"),
            MoreItem(R.drawable.logo, "Settings"),
            MoreItem(R.drawable.logo, "About Cricbuzz")
        )

        val adapter = MoreAdapter(this, moreItemList)
        moreListView.adapter = adapter
    }
}
