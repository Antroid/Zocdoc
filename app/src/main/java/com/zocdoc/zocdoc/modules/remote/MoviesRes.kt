package com.zocdoc.zocdoc.modules.remote

import com.google.gson.annotations.SerializedName
import com.zocdoc.zocdoc.modules.local.MovieItem
import com.zocdoc.zocdoc.modules.local.Movies

data class MoviesRes(
	val movies: List<MovieItemRes>? = null
){
	fun buildMovies(): Movies {

		val movieList = ArrayList<MovieItem>()

		movies?.iterator()?.forEach { movie ->

			movieList.add(movie.buildMovie())
		}
		return Movies(movieList)
	}
}

data class MovieItemRes(

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
){
	fun buildMovie(): MovieItem {
		return MovieItem(description,director, rank, duration, actors, genres, id, name)
	}

}

