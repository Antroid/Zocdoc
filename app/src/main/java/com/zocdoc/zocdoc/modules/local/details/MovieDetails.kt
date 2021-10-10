package com.zocdoc.zocdoc.modules.local.details

data class MovieDetails(
    val actors: List<String>,
    val description: String,
    val director: String,
    val duration: String,
    val genres: List<String>,
    val id: Int,
    val name: String
)