package com.example.cricbuzz_swaroop

data class CricketMatch(
    val trophyName: String,  // Added trophy name
    val matchName: String,   // Added match name
    val team1: String,
    val team2: String,
    val team1Score: String,
    val team2Score: String,
    val winner: String,
    val team1Flag: Int,  // Resource ID for team 1's flag image
    val team2Flag: Int,  // Resource ID for team 2's flag image
    val category: String // New field for filtering (e.g., "International", "ODI", "T20")
)

