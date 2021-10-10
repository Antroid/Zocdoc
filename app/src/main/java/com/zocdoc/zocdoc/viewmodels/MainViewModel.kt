package com.zocdoc.zocdoc.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.zocdoc.zocdoc.modules.local.details.MoviesDetails
import com.zocdoc.zocdoc.modules.local.movies.Movies
import com.zocdoc.zocdoc.modules.local.ranking.RankingMovies
import com.zocdoc.zocdoc.repositories.MoviesRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject
constructor() : ViewModel() {

    companion object{
        private const val TAG = "MainViewModel"
    }

    private var disposable: CompositeDisposable? = null

    @Inject
    lateinit var moviesRepository: MoviesRepository

    init {
        disposable = CompositeDisposable()
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }

    fun loadMovies() {
        disposable?.add(
            moviesRepository.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(MoviesDisposableObserver())
        )
    }

    fun loadMoviesDetails(movieIds: IntArray) {
        disposable?.add(
            moviesRepository.getMoviesDetails(movieIds)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(MoviesDetailsDisposableObserver())
        )
    }

    fun loadRankingMovies(index: Int, numMovies: Int){
        disposable?.add(
            moviesRepository.getMoviesByRanking(index, numMovies)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(RankingMoviesDetailsDisposableObserver())
        )
    }

    private inner class RankingMoviesDetailsDisposableObserver : DisposableObserver<RankingMovies>(){
        override fun onComplete() {
        }

        override fun onNext(t: RankingMovies) {
            Log.d(TAG, "RankingMoviesDetailsDisposableObserver onSuccess ${t.size}")
            Log.d(TAG,t[0].name)
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "RankingMoviesDetailsDisposableObserver onError ${e.message}")
        }
    }

    private inner class MoviesDetailsDisposableObserver : DisposableObserver<MoviesDetails>(){
        override fun onComplete() {
        }

        override fun onNext(t: MoviesDetails) {
            Log.d(TAG, "MoviesDetailsDisposableObserver onSuccess ${t.size}")
            Log.d(TAG,t[0].name)
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "MoviesDetailsDisposableObserver onError ${e.message}")
        }
    }

    private inner class MoviesDisposableObserver : DisposableObserver<Movies>(){
        override fun onComplete() {
        }

        override fun onNext(t: Movies) {
            Log.d(TAG, "MoviesDisposableObserver onSuccess ${t.size}")
            Log.d(TAG,t[0].name)
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "MoviesDisposableObserver onError ${e.message}")
        }
    }

}