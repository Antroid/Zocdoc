package com.zocdoc.zocdoc.di.modules

import com.zocdoc.zocdoc.repositories.RemoteMoviesRepo
import com.zocdoc.zocdoc.services.MovieService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MoviesRepositoryModule {

    @Singleton
    @Provides
    fun provideRemoteMoviesRep(movieService: MovieService) : RemoteMoviesRepo
    {
        return RemoteMoviesRepo(movieService)
    }

}