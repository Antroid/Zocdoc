package com.zocdoc.zocdoc.repositories

import com.zocdoc.zocdoc.Consts.Companion.AUTH_TOKEN
import com.zocdoc.zocdoc.modules.remote.MoviesByRankingRes
import com.zocdoc.zocdoc.modules.remote.MoviesDetailsRes
import com.zocdoc.zocdoc.modules.remote.MoviesRes
import com.zocdoc.zocdoc.services.MovieService
import io.reactivex.Single
import javax.inject.Inject

class RemoteMoviesRepo@Inject constructor(private var moviesService: MovieService)
{
    fun getMovies(): Single<MoviesRes> {
        return moviesService.getAllMoviesResponse(AUTH_TOKEN)
    }

    fun getMoviesByRanking(index: Int, numMovies: Int): Single<MoviesByRankingRes>{
        return moviesService.getMoviesByRankingResponse(AUTH_TOKEN, index, numMovies)
    }

    fun getMoviesDetails(moviesIds: IntArray): Single<MoviesDetailsRes> {
        return moviesService.getMoviesDetailsResponse(AUTH_TOKEN, moviesIds)
    }
}