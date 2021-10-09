package com.zocdoc.zocdoc.di.components

import android.app.Application
import com.zocdoc.zocdoc.di.modules.ActivityBindingModule
import com.zocdoc.zocdoc.di.modules.ApplicationModule
import com.zocdoc.zocdoc.di.modules.ContextModule
import com.zocdoc.zocdoc.di.modules.MoviesRepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, ApplicationModule::class,
    AndroidSupportInjectionModule::class, ActivityBindingModule::class,
    MoviesRepositoryModule::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: Application)

}