package com.example.cricbuzz_swaroop

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Wait for 2 seconds before navigating to the main activity or login
        Handler().postDelayed({
            val isLoggedIn = checkIfUserIsLoggedIn()  // Check if the user is logged in

            val intent = if (isLoggedIn) {
                // If logged in, navigate to the WelcomeActivity (instead of MainActivity)
                Intent(this, WelcomeActivity::class.java)
            } else {
                // If not logged in, navigate to the LoginActivity
                Intent(this, LoginActivity::class.java)
            }
            startActivity(intent)
            finish()  // Close the Splash Activity
        }, 2000) // 2-second delay
    }

    private fun checkIfUserIsLoggedIn(): Boolean {
        // Check login status from SharedPreferences
        val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }
}
