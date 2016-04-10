package com.github.chuross.trancebaka.domain.playlist

import com.github.chuross.trancebaka.domain.track.TrackConverter
import com.github.chuross.trancebaka.domain.user.UserConverter
import com.github.chuross.trancebaka.infrastructure.soundcloud.resource.Playlist as PlaylistResource


final class PlaylistMetaInfoConverter {

    private constructor()

    companion object {

        fun convertToModel(resource: PlaylistResource): PlaylistMetaInfo {
            return PlaylistMetaInfo(
                    user = resource.user?.let { UserConverter.convertTomodel(it) },
                    title = resource.title ?: "no title",
                    description = resource.description,
                    duration = resource.duration ?: 0,
                    streamable = resource.streamable ?: false,
                    tracks = TrackConverter.convertToModels(resource.tracks),
                    createdAt = resource.createdAt,
                    artworkUrl = resource.artworkUrl
            )
        }
    }
}