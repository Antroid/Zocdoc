package com.zocdoc.zocdoc.repositories

import com.zocdoc.zocdoc.modules.local.Movies
import com.zocdoc.zocdoc.modules.remote.MoviesRes
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
        val singleMovies = rMoviesRepo.getMovies().flatMapMaybe { res->
            Maybe.just(res.buildMovies())
        }
        return singleMovies.toObservable()
    }
}