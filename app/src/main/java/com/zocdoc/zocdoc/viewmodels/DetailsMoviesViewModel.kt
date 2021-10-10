package com.zocdoc.zocdoc.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
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

class DetailsMoviesViewModel @Inject constructor() : ViewModel(){

    companion object{
        private const val TAG = "DetailsMoviesViewModel"
    }

    val moviesDetailsData = MutableLiveData<MoviesDetails>()

    val errorLoadError = MutableLiveData<Boolean>()

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

    fun loadMoviesDetails(movieIds: IntArray) {
        disposable?.add(
            moviesRepository.getMoviesDetails(movieIds)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(MoviesDetailsDisposableObserver())
        )
    }


    private inner class MoviesDetailsDisposableObserver : DisposableObserver<MoviesDetails>(){
        override fun onComplete() {
        }

        override fun onNext(t: MoviesDetails) {
            Log.d(TAG, "MoviesDetailsDisposableObserver onSuccess ${t.size}")
            moviesDetailsData.value = t
            errorLoadError.value = false
        }

        override fun onError(e: Throwable) {
            Log.d(TAG, "MoviesDetailsDisposableObserver onError ${e.message}")
            errorLoadError.value = true
        }
    }

}