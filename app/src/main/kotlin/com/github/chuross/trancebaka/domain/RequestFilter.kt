package com.github.chuross.trancebaka.domain

import com.github.chuross.trancebaka.infrastructure.soundcloud.RequestContext
import java.util.*


class RequestFilter {

    val tags: String
    val filter: String?
    val createdAtFrom: String?
    val createdAtTo: String?

    private constructor(tags: String, filter: String?, createdAtFrom: String?, createdAtTo: String?) {
        this.tags = tags
        this.filter = filter
        this.createdAtFrom = createdAtFrom
        this.createdAtTo = createdAtTo
    }

    companion object {
        class Builder(private val requestContext: RequestContext) {

            var tags: List<String> = listOf()
            var filter: String? = null
            var createdAtFrom: Date? = null
            var createdAtTo: Date? = null

            fun build(): RequestFilter {
                return RequestFilter(
                        tags = tags.joinToString(","),
                        filter = filter,
                        createdAtFrom = createdAtFrom?.let { requestContext.dateRequestParameter(it) },
                        createdAtTo = createdAtTo?.let { requestContext.dateRequestParameter(it) }
                )
            }
        }
    }

}