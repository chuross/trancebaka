package com.github.chuross.trancebaka.domain.playlist

import com.github.chuross.trancebaka.application.Application
import com.github.chuross.trancebaka.domain.RequestFilter
import com.github.chuross.trancebaka.infrastructure.rx.RxUtils
import com.github.chuross.trancebaka.infrastructure.soundcloud.Api
import rx.Observable
import javax.inject.Inject


class PlaylistRepository {

    @Inject
    lateinit var application: Application

    @Inject
    lateinit var api: Api

    fun list(query: String, filter: RequestFilter?, limit: Int?, offset: Int?): Observable<List<Playlist>> = RxUtils.networkConnected(application)
            .flatMap {
                api.playlists(application.requestContext.clientId,
                        query = query,
                        tags = filter?.let { filter.tags },
                        filter = filter?.let { filter.filter },
                        createdAtFrom = filter?.let { filter.createdAtFrom },
                        createdAtTo = filter?.let { filter.createdAtTo },
                        limit = limit,
                        offset = offset
                )
            }
            .map { PlaylistConverter.convertToModels(it) }
}