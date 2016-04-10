package com.github.chuross.trancebaka.domain.track

import org.apache.commons.lang3.StringUtils
import com.github.chuross.trancebaka.infrastructure.soundcloud.resource.Track as Resource


final class TrackConverter {

    private constructor()

    companion object {

        fun convertToModel(resource: Resource): Track? {
            if (StringUtils.isBlank(resource.id)) return null
            return Track(TrackIdentity(resource.id!!)).apply {
                metaInfo = TrackMetaInfoConverter.convertToModel(resource)
            }
        }
    }
}