package com.github.chuross.trancebaka.domain.track

import com.github.chuross.trancebaka.domain.user.UserConverter
import com.github.chuross.trancebaka.infrastructure.soundcloud.resource.Track as TrackResource

final class TrackMetaInfoConverter {

    private constructor()

    companion object {

        fun convertToModel(resource: TrackResource): TrackMetaInfo = TrackMetaInfo(
                title = resource.title ?: "no title",
                user = resource.user?.let { UserConverter.convertTomodel(it) },
                description = resource.description,
                duration = resource.duration ?: 0,
                streamable = resource.streamable ?: false,
                createdAt = resource.createdAt,
                streamUrl = resource.streamUrl,
                purchaseUrl = resource.purchaseUrl,
                artworkUrl = resource.artworkUrl,
                waveformUrl = resource.waveformUrl,
                playbackCount = resource.playbackCount ?: 0,
                favoritingsCount = resource.favoritingsCount ?: 0
        )
    }

}