package com.zocdoc.zocdoc.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import com.zocdoc.zocdoc.Consts.Companion.ZOC_DOC_HOME_PAGE
import com.zocdoc.zocdoc.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.movie_details_activity.*


class MovieDetails: DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.movie_details_activity)

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