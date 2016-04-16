package com.github.chuross.trancebaka.application

import android.app.Application
import com.github.chuross.trancebaka.domain.playlist.PlaylistRepository
import com.github.chuross.trancebaka.infrastructure.soundcloud.RequestContext


class Application : Application() {

    val requestContext by lazy {
        // TODO ベースURLをBuildConfig経由から取得
        RequestContext("", "")
    }
    val playlistRepository: PlaylistRepository get() = PlaylistRepository().apply { component.inject(this) }

    private val component by lazy { DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build() }
}