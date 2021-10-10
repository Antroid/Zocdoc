package com.zocdoc.zocdoc.modules.local.movies

data class Movie(
    val actors: List<String>,
    val description: String,
    val director: String,
    val duration: String,
    val genres: List<String>,
    val id: Int,
    val name: String,
    val rank: Int
)
