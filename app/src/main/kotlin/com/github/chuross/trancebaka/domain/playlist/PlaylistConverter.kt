package com.github.chuross.trancebaka.domain.playlist

import org.apache.commons.lang3.StringUtils
import com.github.chuross.trancebaka.infrastructure.soundcloud.resource.Playlist as PlaylistResource

final class PlaylistConverter {

    private constructor()

    companion object {

        fun convertToModel(resource: PlaylistResource): Playlist? {
            if (StringUtils.isBlank(resource.id)) return null
            return Playlist(PlaylistIdentity(resource.id!!)).apply {
                metaInfo = PlaylistMetaInfoConverter.convertToModel(resource)
            }
        }
    }

}