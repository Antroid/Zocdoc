package com.zocdoc.zocdoc.modules.remote

import com.google.gson.annotations.SerializedName

data class MoviesDetailsRes(

	@field:SerializedName("MovieDetails")
	val movieDetails: List<MovieDetailsItemRes>? = null
)

data class MovieDetailsItemRes(

	@field:SerializedName("Description")
	val description: String? = null,

	@field:SerializedName("Director")
	val director: String? = null,

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
