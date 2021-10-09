package com.zocdoc.zocdoc.modules

import com.google.gson.annotations.SerializedName

data class Movies(

	@field:SerializedName("Movies")
	val movies: List<MoviesItem?>? = null
)

data class MoviesItem(

	@field:SerializedName("Description")
	val description: String? = null,

	@field:SerializedName("Director")
	val director: String? = null,

	@field:SerializedName("Rank")
	val rank: Int? = null,

	@field:SerializedName("Duration")
	val duration: String? = null,

	@field:SerializedName("Actors")
	val actors: List<String?>? = null,

	@field:SerializedName("Genres")
	val genres: List<String?>? = null,

	@field:SerializedName("Id")
	val id: Int? = null,

	@field:SerializedName("Name")
	val name: String? = null
)
