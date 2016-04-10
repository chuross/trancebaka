package com.github.chuross.trancebaka.domain.playlist

import com.github.chuross.trancebaka.domain.track.Track
import com.github.chuross.trancebaka.domain.user.User
import java.util.*

data class PlaylistMetaInfo(
        val title: String,
        val user: User?,
        val description: String?,
        val duration: Int,
        val streamable: Boolean,
        val tracks: List<Track>,
        val createdAt: Date?,
        val artworkUrl: String?
)