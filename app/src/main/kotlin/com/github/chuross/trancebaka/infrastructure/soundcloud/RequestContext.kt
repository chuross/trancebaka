package com.github.chuross.trancebaka.infrastructure.soundcloud

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class RequestContext(val baseUrl: String, val clientId: String) {

    companion object {
        private val DATE_FORMAT: DateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
    }

    fun dateRequestParameter(date: Date) = DATE_FORMAT.format(date)

}