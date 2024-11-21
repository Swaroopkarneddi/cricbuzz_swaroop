package com.example.cricbuzz_swaroop

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test


class loginandregisterTestTest {

    @Test
    fun `checkusername`() {
        val v=loginandregisterTest
        assertTrue(v.checkusername("swaroop"))

    }

    @Test
    fun `checkpassword`() {
        val v=loginandregisterTest
        assertTrue(v.checkpassword("swaroop"))
    }
    @Test
    fun `checkusernameFalse`() {
        val v=loginandregisterTest
        assertFalse(!v.checkusername("swaroop"))

    }

    @Test
    fun `checkpasswordFalse`() {
        val v=loginandregisterTest
        assertFalse(!v.checkpassword("swaroop"))
    }
}