package com.github.chuross.trancebaka.domain.base

interface Entity<IDENTITY : Identity<*>> {

    val identity: IDENTITY

    override fun equals(other: Any?): Boolean

    override fun hashCode(): Int
}