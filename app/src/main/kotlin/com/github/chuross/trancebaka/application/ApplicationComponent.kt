package com.github.chuross.trancebaka.application

import com.github.chuross.trancebaka.domain.playlist.PlaylistRepository
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {


    fun inject(repository: PlaylistRepository)
}