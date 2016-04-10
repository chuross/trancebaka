package com.github.chuross.trancebaka.infrastructure.soundcloud

import com.github.chuross.trancebaka.infrastructure.soundcloud.resource.AuthorizationToken
import com.github.chuross.trancebaka.infrastructure.soundcloud.resource.Playlist
import com.github.chuross.trancebaka.infrastructure.soundcloud.resource.Track
import com.github.chuross.trancebaka.infrastructure.soundcloud.resource.User
import retrofit2.http.*
import rx.Observable

interface Api {

    @GET("oauth2/token")
    fun token(
            @Query("client_id") clientId: String,
            @Query("client_secret") clientSecret: String,
            @Query("code") code: String
    ): Observable<AuthorizationToken>

    @GET("tracks/{track_id}")
    fun track(
            @Path("track_id") trackId: String,
            @Query("client_id") clientId: String
    ): Observable<Track>

    @GET("tracks")
    fun tracks(
            @Query("client_id") clientId: String,
            @Query("q") query: String,
            @Query("tags") tags: String = "",
            @Query("filter") filter: String = "",
            @Query("created_at[from]") createdAtFrom: String = "1970/01/01 00:00:00",
            @Query("created_at[to]") createdAtTo: String = "9999/12/31 23:59:59",
            @Query("limit") limit: Int = 10,
            @Query("offset") offset: Int = 0
    ): Observable<List<Track>>

    @GET("playlists/{playlist_id}")
    fun playlist(
            @Path("playlist_id") playlistId: String,
            @Query("client_id") clientId: String
    ): Observable<Playlist>

    @GET("playlists")
    fun playlists(
            @Query("client_id") clientId: String,
            @Query("q") query: String,
            @Query("tags") tags: String = "",
            @Query("filter") filter: String = "",
            @Query("created_at[from]") createdAtFrom: String = "1970/01/01 00:00:00",
            @Query("created_at[to]") createdAtTo: String = "9999/12/31 23:59:59",
            @Query("limit") limit: Int = 10,
            @Query("offset") offset: Int = 0
    ): Observable<List<Playlist>>

    @PUT("playlists")
    fun playlists(
            @Header("Authorization") accessToken: String,
            @Query("client_id") clientId: String,
            @Query("playlist[title]") title: String,
            @Query("playlist[sharing]") sharing: String = "private",
            @Query("playlist[ids][][id]") trackIds: List<String>
    ): Observable<Playlist>

    @GET("users/{user_id}")
    fun user(
            @Query("client_id") clientId: String,
            @Path("user_id") userId: String
    ): Observable<User>
}