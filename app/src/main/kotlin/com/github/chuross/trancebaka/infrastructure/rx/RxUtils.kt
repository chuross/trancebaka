package com.github.chuross.trancebaka.infrastructure.rx

import android.content.Context
import com.github.chuross.trancebaka.infrastructure.android.SystemUtils
import com.github.chuross.trancebaka.infrastructure.exception.NetworkDisconnectedException
import rx.Observable


object RxUtils {

    fun networkConnected(context: Context): Observable<Boolean> = Observable.create {
        if (SystemUtils.checkNetworkConnected(context)) {
            it.onNext(true)
        } else {
            it.onError(NetworkDisconnectedException())
        }
    }
}