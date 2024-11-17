package com.example.cricbuzz_swaroop

data class Player(
    val name: String,
    val description: String,
    val runs: Int,
    val balls: Int,
    val fours: Int,
    val sixes: Int,
    val strikeRate: Float
)
