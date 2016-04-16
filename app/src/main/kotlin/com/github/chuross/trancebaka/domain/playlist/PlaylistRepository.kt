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

    fun get(identity: PlaylistIdentity): Observable<Playlist> = RxUtils.networkConnected(application)
            .flatMap { api.playlist(application.requestContext.clientId, identity.value) }
            .map { PlaylistConverter.convertToModel(it) }

    fun getList(query: String, filter: RequestFilter?, limit: Int?, offset: Int?): Observable<List<Playlist>> = RxUtils.networkConnected(application)
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

    fun put(playlist: Playlist): Observable<Playlist> {
        val tracks = playlist.tracks.map { it.identity.value }

        return RxUtils.networkConnected(application)
                .flatMap {
                    if (!playlist.isUnresolved) {
                        return@flatMap api.updatePlaylist(application.authenticatedUser?.accessToken ?: "", playlist.identity.value, tracks)
                    }
                    api.createPlaylist(application.authenticatedUser?.accessToken ?: "", application.requestContext.clientId,
                            title = playlist.title ?: "no name",
                            sharing = playlist.sharing ?: "private",
                            trackIds = tracks)
                }
                .map { PlaylistConverter.convertToModel(it) }
    }
}