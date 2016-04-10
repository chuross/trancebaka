package com.github.chuross.trancebaka.domain.track

import com.github.chuross.trancebaka.domain.user.User
import java.util.*

data class TrackMetaInfo(
        val title: String,
        val user: User?,
        val description: String?,
        val duration: Long = 0,
        val streamable: Boolean = false,
        val createdAt: Date?,
        val streamUrl: String?,
        val purchaseUrl: String?,
        val artworkUrl: String?,
        val waveformUrl: String?,
        val playbackCount: Int = 0,
        val favoritingsCount: Int = 0
)