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
            NewsItem(R.drawable.news_img1, "Hamilton picks five as Heat comfortably overcome Stars", "Meanwhile, rain had the final say in the Sydney derby as both teams split the points"),
            NewsItem(R.drawable.news_img2, "Padikkal to stay back in Australia; No plans to rush Shami yet", "While Rohit Sharma's participation in Perth seems unlikely, India received a boost as KL Rahul returned to bat in the simulations"),
            NewsItem(R.drawable.news_img3, "Injured Healy out of WBBL 2024, doubtful for India ODIs", "Australia captain has suffered a knee injury with further assessments needed to ascertain comeback date"),
            NewsItem(R.drawable.news_img5, "Lewis, Hope star in consolation win", "The duo put on a 136-run opening stand in just 9.1 overs to set up the massive chase of 219"),
            NewsItem(R.drawable.news_img4, "Gill set to miss Perth Test after injuring his thumb", "India's No. 3 injured his left thumb while taking a catch during a practice game on Saturday"),
            NewsItem(R.drawable.news_img6, "Ranji Trophy: Shami picks three in Bengal's thrilling win ", "Elsewhere, Mumbai, Saurashtra and Tamil Nadu registered wins"),
            NewsItem(R.drawable.news_img7, "Johnson 5-fer helps Australia clinch thriller", "The hosts secured a 13-run win to go 2-up in the three-match T20I series against Pakistan"),
            NewsItem(R.drawable.news_img8, "Penna, McGrath help Strikers snap 5-match losing streak", "Despite being in a tricky situation at 45/4, Penna played a crucial knock of 60 to take the Strikers to a respectable score"),
            NewsItem(R.drawable.news_img9, "Learnt decision-making under pressure from observing Bumrah - Anshul Kamboj ", "The 23-year-old Haryana pacer became only the third bowler in Ranji Trophy history to achieve the 'Perfect Ten'"),
            NewsItem(R.drawable.news_img10, "Hard toil in the nets and improved second stint - Kohli's day out at WACA", "Gill, Jaiswal too had decent hits out in the middle, while Bumrah was involved in long chats with Gambhir")
        )

        val adapter = NewsAdapter(newsList)
        recyclerView.adapter = adapter
    }
}
