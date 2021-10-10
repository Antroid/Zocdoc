package com.zocdoc.zocdoc.repositories

import com.zocdoc.zocdoc.Consts.Companion.AUTH_TOKEN
import com.zocdoc.zocdoc.modules.remote.details.RemoteMoviesDetails
import com.zocdoc.zocdoc.modules.remote.movies.RemoteMovies
import com.zocdoc.zocdoc.modules.remote.ranking.RemoteRankingMovies
import com.zocdoc.zocdoc.services.MovieService
import io.reactivex.Single
import javax.inject.Inject

class RemoteMoviesRepo@Inject constructor(private var moviesService: MovieService)
{
    fun getMovies(): Single<RemoteMovies> {
        return moviesService.getAllMoviesResponse(AUTH_TOKEN)
    }

    fun getMoviesByRanking(index: Int, numMovies: Int): Single<RemoteRankingMovies>{
        return moviesService.getMoviesByRankingResponse(AUTH_TOKEN, index, numMovies)
    }

    fun getMoviesDetails(moviesIds: IntArray): Single<RemoteMoviesDetails> {
        return moviesService.getMoviesDetailsResponse(AUTH_TOKEN, moviesIds)
    }
}