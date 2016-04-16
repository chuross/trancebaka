package com.github.chuross.trancebaka.infrastructure.soundcloud.resource

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class Playlist(
        val id: String?,
        val user: User?,
        val title: String?,
        val description: String?,
        val duration: Int?,
        val streamable: Boolean?,
        val sharing: String?,
        val tracks: List<Track> = emptyList(),
        @JsonProperty("created_at") val createdAt: Date?,
        @JsonProperty("artwork_url") val artworkUrl: String?
)