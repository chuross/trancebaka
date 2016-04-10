package com.github.chuross.trancebaka.domain.base

import org.apache.commons.lang3.builder.HashCodeBuilder

abstract class AbstractEntity<IDENTITY : Identity<*>>(override val identity: IDENTITY) : Entity<IDENTITY> {

    override fun equals(other: Any?): Boolean {
        return other != null
                && other.javaClass.equals(this.javaClass)
                && (other as Entity<*>).identity.value!!.equals(identity.value)
    }

    override fun hashCode(): Int = HashCodeBuilder()
            .append(this.javaClass.simpleName)
            .append(identity.value)
            .build()
}