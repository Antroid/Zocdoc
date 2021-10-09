package com.zocdoc.zocdoc.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.zocdoc.zocdoc.R
import com.zocdoc.zocdoc.viewmodels.MainViewModel
import com.zocdoc.zocdoc.viewmodels.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @set:Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        moviesViewModel.loadMovies()
    }
}