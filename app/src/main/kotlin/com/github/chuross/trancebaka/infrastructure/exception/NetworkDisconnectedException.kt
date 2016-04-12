package com.github.chuross.trancebaka.infrastructure.exception


class NetworkDisconnectedException : Exception {

    constructor() : super()

    constructor(detailMessage: String?) : super(detailMessage)

    constructor(detailMessage: String?, throwable: Throwable?) : super(detailMessage, throwable)

    constructor(throwable: Throwable?) : super(throwable)
}