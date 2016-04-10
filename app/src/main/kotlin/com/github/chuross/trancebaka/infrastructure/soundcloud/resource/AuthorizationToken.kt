package com.github.chuross.trancebaka.infrastructure.soundcloud.resource

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class AuthorizationToken(
        @JsonProperty("access_token") val accessToken: String?
)