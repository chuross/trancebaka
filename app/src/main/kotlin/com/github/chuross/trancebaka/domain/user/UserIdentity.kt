package com.github.chuross.trancebaka.domain.user

import com.github.chuross.trancebaka.domain.base.Identity

data class UserIdentity(override val value: String) : Identity<String>