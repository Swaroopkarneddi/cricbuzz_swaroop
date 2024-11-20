package com.example.cricbuzz_swaroop

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        // Set News Details
        val newsTitle = intent.getStringExtra("newsTitle")
        val newsDescription = intent.getStringExtra("newsDescription")
        val newsImageResId = intent.getIntExtra("newsImageResId", -1)

        val titleTextView: TextView = findViewById(R.id.news_title)
        val descriptionTextView: TextView = findViewById(R.id.news_description)
        val imageView: ImageView = findViewById(R.id.news_image)

        titleTextView.text = newsTitle
        descriptionTextView.text = newsDescription
        if (newsImageResId != -1) {
            imageView.setImageResource(newsImageResId)
        }

        // Set up Bottom Navigation Bar
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val bottomNavView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    navigateToActivity(WelcomeActivity::class.java)
                    true
                }
                R.id.nav_news -> true // Already in News, do nothing
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
}
