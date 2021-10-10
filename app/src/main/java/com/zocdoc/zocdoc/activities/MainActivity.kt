package com.zocdoc.zocdoc.activities

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.zocdoc.zocdoc.R
import com.zocdoc.zocdoc.modules.local.ranking.RankingMovies
import com.zocdoc.zocdoc.viewmodels.MainViewModel
import com.zocdoc.zocdoc.viewmodels.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), RankingMovieListener {

    @set:Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var adapter: RankingMoviesRecycleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        adapter = RankingMoviesRecycleViewAdapter(this)
        val movieLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rankingMoviesRecycleView.layoutManager = movieLayoutManager
        rankingMoviesRecycleView.adapter = adapter

        moviesViewModel.rankingMoviesData.observe(this, Observer<RankingMovies> { data ->
            adapter.setData(data)
        })

        moviesViewModel.loadRankingMovies(0,10)
    }

    private fun initRankingObservable() {

    }

    override fun onMovieClicked(movieId: Int) {
        Toast.makeText(this,movieId.toString(), Toast.LENGTH_LONG).show()
    }


}