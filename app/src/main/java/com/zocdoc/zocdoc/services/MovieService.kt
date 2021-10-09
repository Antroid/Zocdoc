package com.zocdoc.zocdoc.services

import com.zocdoc.zocdoc.modules.remote.MoviesByRankingRes
import com.zocdoc.zocdoc.modules.remote.MoviesDetailsRes
import com.zocdoc.zocdoc.modules.remote.MoviesRes
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

        @GET("/api/1/FEE/AllMovies/")
        fun getAllMoviesResponse(@Query("authToken") apiKey : String) : Single<MoviesRes>

        @GET("/api/1/FEE/MoviesByRank/")
        fun getMoviesByRankingResponse(@Query("authToken") apiKey : String, @Query("startRankIndex") startRankIndex: Int, @Query("numMovies") numMovies: Int) : Single<MoviesByRankingRes>

        @GET("/api/1/FEE/MovieDetails/")
        fun getMoviesDetailsResponse(@Query("authToken") apiKey : String, @Query("movieIds") movieIds: IntArray) : Single<MoviesDetailsRes>

}