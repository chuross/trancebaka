package com.github.chuross.trancebaka.infrastructure.extension

import rx.Observable
import rx.Scheduler
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers

fun <T> Observable<T>.subscribeOnAsync(subscribeOn: Scheduler): Subscription {
    return subscribeOn(subscribeOn).observeOn(AndroidSchedulers.mainThread()).subscribe()
}