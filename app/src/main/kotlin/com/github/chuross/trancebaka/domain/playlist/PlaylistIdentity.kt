package com.github.chuross.trancebaka.domain.playlist

import com.github.chuross.trancebaka.domain.base.Identity


data class PlaylistIdentity(override val value: String) : Identity<String>