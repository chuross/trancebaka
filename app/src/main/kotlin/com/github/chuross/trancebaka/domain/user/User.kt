package com.github.chuross.trancebaka.domain.user

import com.github.chuross.trancebaka.domain.base.AbstractEntity

class User(identity: UserIdentity) : AbstractEntity<UserIdentity>(identity) {

    var metaInfo: UserMetaInfo? = null
}