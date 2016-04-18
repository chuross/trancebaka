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
            @Query("client_id") clientId: String,
            @Path("track_id") trackId: String
    ): Observable<Track>

    @GET("tracks")
    fun tracks(
            @Query("client_id") clientId: String,
            @Query("q") query: String,
            @Query("tags") tags: String? = null,
            @Query("filter") sharing: String? = null,
            @Query("created_at[from]") createdAtFrom: String? = null,
            @Query("created_at[to]") createdAtTo: String? = null,
            @Query("limit") limit: Int? = 10,
            @Query("offset") offset: Int? = 0
    ): Observable<List<Track>>

    @GET("playlists/{playlist_id}")
    fun playlist(
            @Query("client_id") clientId: String,
            @Path("playlist_id") playlistId: String
    ): Observable<Playlist>

    @GET("playlists")
    fun playlists(
            @Query("client_id") clientId: String,
            @Query("q") query: String,
            @Query("tags") tags: String? = null,
            @Query("filter") sharing: String? = null,
            @Query("created_at[from]") createdAtFrom: String? = null,
            @Query("created_at[to]") createdAtTo: String? = null,
            @Query("limit") limit: Int? = 10,
            @Query("offset") offset: Int? = 0
    ): Observable<List<Playlist>>

    @POST("playlists")
    fun createPlaylist(
            @Header("Authorization") accessToken: String,
            @Query("client_id") clientId: String,
            @Query("title") title: String,
            @Query("sharing") sharing: String = "private",
            @Query("tracks[][id]") trackIds: List<String>
    ): Observable<Playlist>

    @PUT("playlists/{playlist_id}")
    fun updatePlaylist(
            @Header("Authorization") accessToken: String,
            @Path("playlist_id") playlistId: String,
            @Query("tracks[][id]") trackIds: List<String>
    ): Observable<Playlist>

    @GET("users/{user_id}")
    fun user(
            @Query("client_id") clientId: String,
            @Path("user_id") userId: String
    ): Observable<User>
}