package com.github.chuross.trancebaka.infrastructure.soundcloud.resource

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class User(
        val id: String?,
        @JsonProperty("username") val name: String?,
        @JsonProperty("avatar_url") val avatarUrl: String?
)