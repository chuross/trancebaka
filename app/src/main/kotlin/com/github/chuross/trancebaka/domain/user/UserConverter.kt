package com.github.chuross.trancebaka.domain.user

import org.apache.commons.lang3.StringUtils
import com.github.chuross.trancebaka.infrastructure.soundcloud.resource.User as UserResource


final class UserConverter {

    private constructor()

    companion object {

        fun convertTomodel(resource: UserResource): User? {
            if (StringUtils.isBlank(resource.id)) return null;
            return User(UserIdentity(resource.id!!)).apply {
                metaInfo = UserMetaInfoConverter.convertToModel(resource)
            };
        }
    }

}