package com.example.cricbuzz_swaroop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

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
    }
}
