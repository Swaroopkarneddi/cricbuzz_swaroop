package com.example.cricbuzz_swaroop

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        dbHelper = DBHelper(this)

        // Wait for 2 seconds before navigating to the main activity or login
        Handler().postDelayed({
            val isLoggedIn = checkIfUserIsLoggedIn()  // Check if the user is logged in

            val intent = if (isLoggedIn) {
                // If logged in, navigate to the main activity
                Intent(this, MainActivity::class.java)
            } else {
                // If not logged in, navigate to the login activity
                Intent(this, LoginActivity::class.java)
            }
            startActivity(intent)
            finish()  // Close the Splash Activity
        }, 2000) // 2-second delay
    }

    private fun checkIfUserIsLoggedIn(): Boolean {
        // You can check login status from SharedPreferences or SQLite
        val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }
}
