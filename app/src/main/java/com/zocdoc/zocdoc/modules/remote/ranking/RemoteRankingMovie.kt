package com.zocdoc.zocdoc.modules.remote.ranking


import com.google.gson.annotations.SerializedName

data class RemoteRankingMovie(
    @SerializedName("Id")
    val id: Int,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Rank")
    val rank: Int
)