package com.github.chuross.trancebaka.domain.playlist

import com.github.chuross.trancebaka.domain.base.AbstractEntity
import com.github.chuross.trancebaka.domain.track.Track
import com.github.chuross.trancebaka.domain.user.User
import java.util.*


class Playlist(identity: PlaylistIdentity) : AbstractEntity<PlaylistIdentity>(identity) {

    companion object {
        val UNRESOLVED_IDENTITY = PlaylistIdentity("no_id")
    }

    var metaInfo: PlaylistMetaInfo? = null

    val isUnresolved: Boolean get() = identity.equals(UNRESOLVED_IDENTITY)
    val title: String? get() = metaInfo?.title
    val user: User? get() = metaInfo?.user
    val description: String? get() = metaInfo?.description
    val duration: Int get() = metaInfo?.duration ?: 0
    val streamable: Boolean get() = metaInfo?.streamable ?: false && metaInfo?.tracks?.isNotEmpty() ?: false
    val sharing: String? get() = metaInfo?.sharing
    val tracks: List<Track> get() = metaInfo?.tracks ?: emptyList()
    val createdAt: Date? get() = metaInfo?.createdAt
    val artworkUrl: String? get() = metaInfo?.artworkUrl
}