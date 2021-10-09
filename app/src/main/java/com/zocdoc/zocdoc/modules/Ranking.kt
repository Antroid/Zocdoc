package com.zocdoc.zocdoc.modules

import com.google.gson.annotations.SerializedName

data class Ranking(

	@field:SerializedName("Ranking")
	val ranking: List<RankingItem?>? = null
)

data class RankingItem(

	@field:SerializedName("Rank")
	val rank: Int? = null,

	@field:SerializedName("Id")
	val id: Int? = null,

	@field:SerializedName("Name")
	val name: String? = null
)
