package com.github.chuross.trancebaka.infrastructure.exception


class UnAuthorizedException : Exception {

    constructor() : super()

    constructor(detailMessage: String?) : super(detailMessage)

    constructor(detailMessage: String?, throwable: Throwable?) : super(detailMessage, throwable)

    constructor(throwable: Throwable?) : super(throwable)
}