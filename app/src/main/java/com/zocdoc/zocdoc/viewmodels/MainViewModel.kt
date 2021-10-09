package com.zocdoc.zocdoc.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.zocdoc.zocdoc.modules.local.Movies
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

    private inner class MoviesDisposableObserver : DisposableObserver<Movies>(){
        override fun onComplete() {
        }

        override fun onNext(t: Movies) {
            Log.d(TAG, "onSuccess ${t.movies?.size}")
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "onError ${e.message}")
        }
    }

}