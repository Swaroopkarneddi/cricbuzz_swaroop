package com.example.cricbuzz_swaroop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Get the username passed from LoginActivity
        val username = intent.getStringExtra("username")

        // Set the username in the welcome message
        val welcomeMessage: TextView = findViewById(R.id.welcome_message)
        welcomeMessage.text = "Welcome, $username!"

        // Initialize the logout button
        val logoutButton: Button = findViewById(R.id.logout_button)

        // Set up the logout button to clear the login state and navigate to LoginActivity
        logoutButton.setOnClickListener {
            // Clear the login state from SharedPreferences
            val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn", false)  // Set login state to false (logged out)
            editor.apply()

            // Navigate back to LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()  // Close WelcomeActivity so the user can't go back to it
        }
    }
}
