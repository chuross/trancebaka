package com.github.chuross.trancebaka.domain.track

import org.apache.commons.lang3.StringUtils
import com.github.chuross.trancebaka.infrastructure.soundcloud.resource.Track as TrackResource


final class TrackConverter {

    private constructor()

    companion object {

        fun convertToModels(resources: List<TrackResource>): List<Track> = resources.map { convertToModel(it) }.filterNotNull()

        fun convertToModel(resource: TrackResource): Track? {
            if (StringUtils.isBlank(resource.id)) return null
            return Track(TrackIdentity(resource.id!!)).apply {
                metaInfo = TrackMetaInfoConverter.convertToModel(resource)
            }
        }
    }
}