package com.github.chuross.trancebaka.domain.track

import com.github.chuross.trancebaka.domain.user.User
import java.util.*

data class TrackMetaInfo(
        val title: String,
        val user: User?,
        val description: String?,
        val duration: Long,
        val streamable: Boolean,
        val createdAt: Date?,
        val streamUrl: String?,
        val purchaseUrl: String?,
        val artworkUrl: String?,
        val waveformUrl: String?,
        val playbackCount: Int,
        val favoritingsCount: Int
)