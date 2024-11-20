package com.example.cricbuzz_swaroop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    fun checkusername(name:String):Boolean{
        if (name.isEmpty()){
            return false
        }
        if(name.length<4){
            return false
        }
        return true
    }
    fun checkpassword(pass:String):Boolean{
        if (pass.isEmpty()){
            return false
        }
        if (pass.length<6){
            return false
        }

        return true
    }

    private lateinit var dbHelper: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        dbHelper = DBHelper(this)

        val usernameEditText: EditText = findViewById(R.id.username_edit_text)
        val passwordEditText: EditText = findViewById(R.id.password_edit_text)
        val registerButton: Button = findViewById(R.id.register_button)
        val loginButton: Button = findViewById(R.id.login_button)  // Button to navigate to LoginActivity

        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (checkusername(username)&& checkpassword(password)) {
                val isInserted = dbHelper.insertUser(username, password)
                if (isInserted) {
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

                    // Optionally log the user in after successful registration
                    val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("isLoggedIn", true)  // Set login state to true
                    editor.apply()

                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Navigate to LoginActivity
        loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
