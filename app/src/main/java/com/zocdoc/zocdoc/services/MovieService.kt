package com.zocdoc.zocdoc.services


import com.zocdoc.zocdoc.modules.remote.details.RemoteMoviesDetails
import com.zocdoc.zocdoc.modules.remote.movies.RemoteMovies
import com.zocdoc.zocdoc.modules.remote.ranking.RemoteRankingMovies
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

        @GET("/api/1/FEE/AllMovies/")
        fun getAllMoviesResponse(@Query("authToken") apiKey : String) : Single<RemoteMovies>

        @GET("/api/1/FEE/MoviesByRank/")
        fun getMoviesByRankingResponse(@Query("authToken") apiKey : String, @Query("startRankIndex") startRankIndex: Int, @Query("numMovies") numMovies: Int) : Single<RemoteRankingMovies>

        @GET("/api/1/FEE/MovieDetails/")
        fun getMoviesDetailsResponse(@Query("authToken") apiKey : String, @Query("movieIds") movieIds: IntArray) : Single<RemoteMoviesDetails>

}