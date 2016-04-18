package com.github.chuross.trancebaka.domain.track

import com.github.chuross.trancebaka.application.Application
import com.github.chuross.trancebaka.domain.RequestFilter
import com.github.chuross.trancebaka.infrastructure.rx.RxUtils
import com.github.chuross.trancebaka.infrastructure.soundcloud.Api
import rx.Observable
import javax.inject.Inject


class TrackRepository {

    @Inject
    lateinit var application: Application

    @Inject
    lateinit var api: Api

    fun find(identity: TrackIdentity): Observable<Track> = RxUtils.networkConnected(application)
            .flatMap { api.track(application.requestContext.clientId, identity.value) }
            .map { TrackConverter.convertToModel(it) }

    fun findAll(query: String, filter: RequestFilter?, limit: Int?, offset: Int?): Observable<List<Track>> = RxUtils.networkConnected(application)
            .flatMap {
                api.tracks(application.requestContext.clientId,
                        query = query,
                        tags = filter?.tags,
                        sharing = filter?.sharing?.value,
                        createdAtFrom = filter?.createdAtFrom,
                        createdAtTo = filter?.createdAtTo,
                        limit = limit,
                        offset = offset
                )
            }
            .map { TrackConverter.convertToModels(it) }

}