package com.github.chuross.trancebaka.infrastructure.soundcloud.resource

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

@JsonIgnoreProperties(ignoreUnknown = true)
data class Track(
        val id: String?,
        val title: String?,
        val user: User,
        val description: String?,
        val duration: Long?,
        val streamable: Boolean?,
        @JsonProperty("created_at") val createdAt: Date?,
        @JsonProperty("stream_url") val streamUrl: String?,
        @JsonProperty("purchase_url") val purchaseUrl: String?,
        @JsonProperty("artwork_url") val artworkUrl: String?,
        @JsonProperty("waveform_url") val waveformUrl: String?,
        @JsonProperty("playback_count") val playbackCount: Int,
        @JsonProperty("favoritings_count") val favoritingsCount: Int
)