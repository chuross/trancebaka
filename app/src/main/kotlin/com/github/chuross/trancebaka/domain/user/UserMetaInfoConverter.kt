package com.github.chuross.trancebaka.domain.user

import com.github.chuross.trancebaka.infrastructure.soundcloud.resource.User as Resource


final class UserMetaInfoConverter {

    private constructor()

    companion object {

        fun convertToModel(resource: Resource) = UserMetaInfo(
                name = resource.name ?: "unknown",
                avatarUrl = resource.avatarUrl
        )
    }

}