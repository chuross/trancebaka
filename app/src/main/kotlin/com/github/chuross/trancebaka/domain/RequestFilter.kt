package com.github.chuross.trancebaka.domain

import com.github.chuross.trancebaka.infrastructure.soundcloud.RequestContext
import java.util.*


class RequestFilter {

    val tags: String
    val sharing: RequestSharing?
    val createdAtFrom: String?
    val createdAtTo: String?

    private constructor(tags: String, sharing: RequestSharing?, createdAtFrom: String?, createdAtTo: String?) {
        this.tags = tags
        this.sharing = sharing
        this.createdAtFrom = createdAtFrom
        this.createdAtTo = createdAtTo
    }

    companion object {
        class Builder(private val requestContext: RequestContext) {

            var tags: List<String> = listOf()
            var sharing: RequestSharing? = null
            var createdAtFrom: Date? = null
            var createdAtTo: Date? = null

            fun build(): RequestFilter {
                return RequestFilter(
                        tags = tags.joinToString(","),
                        sharing = sharing,
                        createdAtFrom = createdAtFrom?.let { requestContext.dateRequestParameter(it) },
                        createdAtTo = createdAtTo?.let { requestContext.dateRequestParameter(it) }
                )
            }
        }
    }

}