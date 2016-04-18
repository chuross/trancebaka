package com.github.chuross.trancebaka.domain.user

import com.github.chuross.trancebaka.application.Application
import com.github.chuross.trancebaka.infrastructure.rx.RxUtils
import com.github.chuross.trancebaka.infrastructure.soundcloud.Api
import rx.Observable


class UserRepository {

    lateinit var application: Application
    lateinit var api: Api

    fun find(identity: UserIdentity): Observable<User> = RxUtils.networkConnected(application)
            .flatMap { api.user(application.requestContext.clientId, identity.value) }
            .map { UserConverter.convertTomodel(it) }
}