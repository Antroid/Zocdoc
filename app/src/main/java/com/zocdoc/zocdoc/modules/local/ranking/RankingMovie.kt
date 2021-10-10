package com.zocdoc.zocdoc.modules.local.ranking

import android.graphics.Color
import kotlin.random.Random

data class RankingMovie(
    val id: Int,
    val name: String,
    val rank: Int
){
    //mock movie poster
    val poster = Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
}