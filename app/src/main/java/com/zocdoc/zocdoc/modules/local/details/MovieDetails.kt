package com.zocdoc.zocdoc.modules.local.details

import android.graphics.Color
import kotlin.random.Random

data class MovieDetails(
    val actors: List<ActorDetails>,
    val description: String,
    val director: String,
    val duration: String,
    val genres: List<String>,
    val id: Int,
    val name: String
)


data class ActorDetails(
    val name: String
){
    //mock actor poster
    val poster = Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
}