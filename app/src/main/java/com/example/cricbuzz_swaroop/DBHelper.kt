package com.example.cricbuzz_swaroop

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "user_db"
        private const val DATABASE_VERSION = 1

        const val TABLE_NAME = "users"
        const val COL_USERNAME = "username"
        const val COL_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME (" +
                "$COL_USERNAME TEXT PRIMARY KEY, " +
                "$COL_PASSWORD TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertUser(username: String, password: String): Boolean {
        val db = writableDatabase
        val insertQuery = "INSERT INTO $TABLE_NAME ($COL_USERNAME, $COL_PASSWORD) VALUES ('$username', '$password')"
        db.execSQL(insertQuery)
        db.close()
        return true
    }

    fun checkUser(username: String, password: String): Boolean {
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COL_USERNAME = '$username' AND $COL_PASSWORD = '$password'"
        val cursor = db.rawQuery(query, null)
        val isValidUser = cursor.count > 0
        cursor.close()
        db.close()
        return isValidUser
    }
}
