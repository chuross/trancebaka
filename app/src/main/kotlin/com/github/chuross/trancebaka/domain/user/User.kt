package com.github.chuross.trancebaka.domain.user

import com.github.chuross.trancebaka.domain.base.AbstractEntity
import org.apache.commons.lang3.StringUtils

class User(identity: UserIdentity) : AbstractEntity<UserIdentity>(identity) {

    var metaInfo: UserMetaInfo? = null
    var authenticationInfo: UserAuthenticationInfo? = null

    val name: String? get() = metaInfo?.name
    val avatarUrl: String? get() = metaInfo?.avatarUrl
    val accessToken: String? get() = authenticationInfo?.accessToken
    val isAuthenticated: Boolean get() = StringUtils.isBlank(authenticationInfo?.accessToken)
}