package com.example.cricbuzz_swaroop

import org.junit.Assert.*
import org.junit.Test

class LoginActivityTest {

     val loginActivity = LoginActivity()

    @Test
    fun `checkusername should return true for non-empty username`() {
        val username = "validUsername"
        assertTrue("Username should not be empty", loginActivity.checkusername(username))
    }

    @Test
    fun `checkusername should return false for empty username`() {
        val username = ""
        assertFalse("Username should be empty", loginActivity.checkusername(username))
    }

    @Test
    fun `checkpassword should return true for non-empty password`() {
        val password = "validPassword"
        assertTrue("Password should not be empty", loginActivity.checkpassword(password))
    }

    @Test
    fun `checkpassword should return false for empty password`() {
        val password = ""
        assertFalse("Password should be empty", loginActivity.checkpassword(password))
    }
}
