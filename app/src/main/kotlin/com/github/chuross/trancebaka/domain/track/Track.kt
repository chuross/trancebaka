package com.github.chuross.trancebaka.domain.track

import com.github.chuross.trancebaka.domain.base.AbstractEntity
import com.github.chuross.trancebaka.domain.user.User
import org.apache.commons.lang3.StringUtils
import java.util.*

class Track(identity: TrackIdentity) : AbstractEntity<TrackIdentity>(identity) {

    var metaInfo: TrackMetaInfo? = null

    val title: String? get() = metaInfo?.title
    val user: User? get() = metaInfo?.user
    val description: String? get() = metaInfo?.description
    val duration: Long get() = metaInfo?.duration ?: 0
    val streamable: Boolean? get() = metaInfo?.streamable ?: false && !StringUtils.isBlank(metaInfo?.streamUrl)
    val createdAt: Date? get() = metaInfo?.createdAt
    val streamUrl: String? get() = metaInfo?.streamUrl
    val purchaseUrl: String? get() = metaInfo?.purchaseUrl
    val artworkUrl: String? get() = metaInfo?.artworkUrl
    val waveformUrl: String? get() = metaInfo?.waveformUrl
    val playbackCount: Int get() = metaInfo?.playbackCount ?: 0
    val favoritingsCount: Int get() = metaInfo?.favoritingsCount ?: 0
}