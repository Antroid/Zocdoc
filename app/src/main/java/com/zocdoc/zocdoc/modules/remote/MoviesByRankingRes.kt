package com.zocdoc.zocdoc.modules.remote

import com.google.gson.annotations.SerializedName

data class MoviesByRankingRes(

	@field:SerializedName("Ranking")
	val ranking: List<RankingItemRes>? = null
)

data class RankingItemRes(

	@field:SerializedName("Rank")
	val rank: Int? = null,

	@field:SerializedName("Id")
	val id: Int? = null,

	@field:SerializedName("Name")
	val name: String? = null
)
