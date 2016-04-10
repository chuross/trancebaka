package com.github.chuross.trancebaka.domain.playlist

import com.github.chuross.trancebaka.domain.base.AbstractEntity


class Playlist(identity: PlaylistIdentity) : AbstractEntity<PlaylistIdentity>(identity) {

    companion object {
        val UNRESOLVED_IDENTITY = -1
    }

    var metaInfo: PlaylistMetaInfo? = null
}