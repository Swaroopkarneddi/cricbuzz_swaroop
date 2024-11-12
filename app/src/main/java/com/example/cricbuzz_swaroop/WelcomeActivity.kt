package com.example.cricbuzz_swaroop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val username = intent.getStringExtra("username")
        val welcomeMessage: TextView = findViewById(R.id.welcome_message)
        welcomeMessage.text = "Welcome, $username!"
    }
}
