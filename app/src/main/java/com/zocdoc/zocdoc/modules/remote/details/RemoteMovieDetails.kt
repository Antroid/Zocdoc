package com.zocdoc.zocdoc.modules.remote.details


import com.google.gson.annotations.SerializedName

data class RemoteMovieDetails(
    @SerializedName("Actors")
    val actors: List<String>,
    @SerializedName("Description")
    val description: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("Duration")
    val duration: String,
    @SerializedName("Genres")
    val genres: List<String>,
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Name")
    val name: String
)