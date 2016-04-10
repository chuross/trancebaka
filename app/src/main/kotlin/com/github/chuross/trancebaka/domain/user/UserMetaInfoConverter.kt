package com.github.chuross.trancebaka.domain.user

import com.github.chuross.trancebaka.infrastructure.soundcloud.resource.User as UserResource


final class UserMetaInfoConverter {

    private constructor()

    companion object {

        fun convertToModel(resource: UserResource) = UserMetaInfo(
                name = resource.name ?: "no name",
                avatarUrl = resource.avatarUrl
        )
    }

}