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
import com.zocdoc.zocdoc.modules.local.details.ActorDetails

class ActorRecycleViewAdapter internal constructor() : RecyclerView.Adapter<ActorRecycleViewAdapter.ActorDetailsViewHolder>() {
    private var data : List<ActorDetails> = ArrayList()

    init {
        setHasStableIds(true)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ActorDetailsViewHolder {
        return ActorDetailsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_actor_item, parent, false))
    }

    override fun onBindViewHolder(@NonNull holder: ActorDetailsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data : List<ActorDetails>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class ActorDetailsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        var actorNameText: TextView = itemView.findViewById(R.id.actorName)
        var actorPoster: ImageView = itemView.findViewById(R.id.actorPoster)

        private lateinit var actorDetails: ActorDetails


        fun bind(actorDetails: ActorDetails) {
            this.actorDetails = actorDetails

            actorNameText.text = actorDetails.name
            actorPoster.setBackgroundColor(actorDetails.poster)

        }
    }
}