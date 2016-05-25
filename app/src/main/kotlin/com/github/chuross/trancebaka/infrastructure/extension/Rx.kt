package com.github.chuross.trancebaka.infrastructure.extension

import rx.Observable
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers


fun <T> Observable<T>.sync(): Observable<T> {
    return subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Observable<T>.async(subscribeOn: Scheduler): Observable<T> {
    return subscribeOn(subscribeOn).observeOn(AndroidSchedulers.mainThread())
}