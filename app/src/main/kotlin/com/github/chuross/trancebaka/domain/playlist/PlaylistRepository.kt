package com.github.chuross.trancebaka.domain.playlist

import com.github.chuross.trancebaka.infrastructure.soundcloud.Api
import javax.inject.Inject


class PlaylistRepository {

    @Inject
    lateinit var api: Api
}