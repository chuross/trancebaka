package com.github.chuross.trancebaka.domain.track

import com.github.chuross.trancebaka.domain.base.AbstractEntity

class Track(identity: TrackIdentity) : AbstractEntity<TrackIdentity>(identity) {

    var metaInfo: TrackMetaInfo? = null
}