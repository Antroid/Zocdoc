package com.zocdoc.zocdoc.activities

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.zocdoc.zocdoc.R
import com.zocdoc.zocdoc.modules.local.ranking.RankingMovie

class RankingMoviesRecycleViewAdapter internal constructor(
    private val movieListener: RankingMovieListener
) : RecyclerView.Adapter<RankingMoviesRecycleViewAdapter.MovieRankingViewHolder>() {
    private var data : List<RankingMovie> = ArrayList()

    init {
        setHasStableIds(true)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): MovieRankingViewHolder {
        return MovieRankingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.ranking_movie_item, parent, false))
    }

    override fun onBindViewHolder(@NonNull holder: MovieRankingViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemId(position: Int): Long {
        return data[position].id.toLong()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data : ArrayList<RankingMovie>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class MovieRankingViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        var movieNameText: TextView = itemView.findViewById(R.id.movieName)
        var moviePoster: ImageView = itemView.findViewById(R.id.moviePoster)
        var movieIdText: TextView = itemView.findViewById(R.id.movieId)
        var movieIndex : TextView = itemView.findViewById(R.id.movieIndex)


        private lateinit var rankingMovie: RankingMovie

        init {
            itemView.setOnClickListener {
                    movieListener.onMovieClicked(rankingMovie.id)
                }
            }

        fun bind(rankingMovie: RankingMovie) {
            this.rankingMovie = rankingMovie

            movieNameText.text = rankingMovie.name
            moviePoster.setBackgroundColor(rankingMovie.poster)
            movieIdText.text = rankingMovie.id.toString()
            movieNameText.text = rankingMovie.name
            movieIndex.text = rankingMovie.rank.toString()

        }
    }
}