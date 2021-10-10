package com.zocdoc.zocdoc.repositories

import com.zocdoc.zocdoc.modules.local.details.MovieDetails
import com.zocdoc.zocdoc.modules.local.details.MoviesDetails
import com.zocdoc.zocdoc.modules.local.movies.Movie
import com.zocdoc.zocdoc.modules.local.movies.Movies
import com.zocdoc.zocdoc.modules.local.ranking.RankingMovie
import com.zocdoc.zocdoc.modules.local.ranking.RankingMovies
import com.zocdoc.zocdoc.modules.remote.details.RemoteMoviesDetails
import com.zocdoc.zocdoc.modules.remote.movies.RemoteMovies
import com.zocdoc.zocdoc.modules.remote.ranking.RemoteRankingMovies
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepository @Inject constructor(
    private var rMoviesRepo: RemoteMoviesRepo
)
{
    fun getMovies(): Observable<Movies> {
        val singleMovies = rMoviesRepo.getMovies().flatMapMaybe { res ->
            Maybe.just(buildMovies(res))
        }
        return singleMovies.toObservable()
    }

    fun getMoviesDetails(movieIds: IntArray): Observable<MoviesDetails> {
        val singleMoviesDetails = rMoviesRepo.getMoviesDetails(movieIds).flatMapMaybe { res ->
            Maybe.just(buildMoviesDetails(res))
        }
        return singleMoviesDetails.toObservable()
    }

    fun getMoviesByRanking(index: Int, numMovies: Int): Observable<RankingMovies> {
        val singleRankingMovies = rMoviesRepo.getMoviesByRanking(index, numMovies).flatMapMaybe { res ->
            Maybe.just(buildRankingMovies(res))
        }
        return singleRankingMovies.toObservable()
    }

    private fun buildRankingMovies(res: RemoteRankingMovies): RankingMovies {
        val rankingMovies = RankingMovies()

        for(item in res){
            rankingMovies.add(RankingMovie(item.id, item.name, item.rank))
        }

        return rankingMovies
    }


    private fun buildMoviesDetails(res: RemoteMoviesDetails): MoviesDetails {
        val moviesDetails = MoviesDetails()
        for(item in res){
            moviesDetails.add(MovieDetails(item.actors, item.description, item.director, item.duration, item.genres, item.id, item.name))
        }
        return moviesDetails
    }

    private fun buildMovies(res: RemoteMovies): Movies {
        val movies = Movies()
        for(item in res){
            movies.add(Movie(item.actors, item.description, item.director, item.duration, item.genres, item.id, item.name, item.rank))
        }
        return movies
    }

}