package com.zocdoc.zocdoc.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.zocdoc.zocdoc.Consts.Companion.MOVIE_ID_KEY
import com.zocdoc.zocdoc.Consts.Companion.ZOC_DOC_HOME_PAGE
import com.zocdoc.zocdoc.R
import com.zocdoc.zocdoc.modules.local.details.MoviesDetails
import com.zocdoc.zocdoc.viewmodels.DetailsMoviesViewModel
import com.zocdoc.zocdoc.viewmodels.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.movie_details_activity.*
import javax.inject.Inject


class MovieDetailsActivity: DaggerAppCompatActivity() {

    @set:Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var adapter: ActorRecycleViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details_activity)

        val detailsMoviesViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(DetailsMoviesViewModel::class.java)

        adapter = ActorRecycleViewAdapter()
        val actorLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        movieActorRecyclerView.layoutManager = actorLayoutManager
        movieActorRecyclerView.adapter = adapter
        detailsMoviesViewModel.moviesDetailsData.observe(this, Observer<MoviesDetails> { data ->
            errorText.isVisible = false
            val movieDetails = data[0]

            movieName.text = movieDetails.name

            var movieGenres = ""
            for(genre in movieDetails.genres){
                movieGenres += "$genre | "
            }
            movieGenresText.text = movieGenres
            durationText.text = movieDetails.duration
            directorText.text = movieDetails.director


            adapter.setData(data[0].actors)
        })

        detailsMoviesViewModel.errorLoadError.observe(this, Observer<Boolean> { error->
            if(error) {
                errorText.isVisible = true
            }
        })

        val movieId = intent.extras?.getInt(MOVIE_ID_KEY) ?: 0

        val moviesIds: IntArray = intArrayOf(movieId)

        detailsMoviesViewModel.loadMoviesDetails(moviesIds)

        booking.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(ZOC_DOC_HOME_PAGE)
                )
            )
        }

    }

}