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
            MoreItem(R.drawable.brouse_settings, "Browse Series"),
            MoreItem(R.drawable.br_teams, "Browse Teams"),
            MoreItem(R.drawable.br_player, "Browse Players"),
            MoreItem(R.drawable.schedule,"Schedule"),
            MoreItem(R.drawable.archives, "Archives"),
            MoreItem(R.drawable.photos_icn, "Photos"),
            MoreItem(R.drawable.quotes, "Quotes"),
            MoreItem(R.drawable.men_rank, "ICC Ranking Men"),
            MoreItem(R.drawable.renking_women, "ICC Ranking Women"),
            MoreItem(R.drawable.folder, "Records"),
            MoreItem(R.drawable.league, "ICC World Test Championship"),
            MoreItem(R.drawable.football_trophy, "ICC World Super League"),
            MoreItem(R.drawable.review, "Rate the App"),
            MoreItem(R.drawable.feedback, "Feedback"),
            MoreItem(R.drawable.settings, "Settings"),
            MoreItem(R.drawable.about, "About Cricbuzz")
        )

        val adapter = MoreAdapter(this, moreItemList)
        moreListView.adapter = adapter
    }
}
