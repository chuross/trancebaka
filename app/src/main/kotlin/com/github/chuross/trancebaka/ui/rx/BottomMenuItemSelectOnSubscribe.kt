package com.github.chuross.trancebaka.ui.rx

import it.sephiroth.android.library.bottomnavigation.BottomNavigation
import rx.Observable
import rx.Subscriber
import rx.android.MainThreadSubscription


class BottomMenuItemSelectOnSubscribe(private val bottomNavigation: BottomNavigation) : Observable.OnSubscribe<Int> {

    override fun call(subscriber: Subscriber<in Int>) {
        bottomNavigation.setOnMenuItemClickListener(object : BottomNavigation.OnMenuItemSelectionListener {
            override fun onMenuItemSelect(itemId: Int, position: Int) {
                subscriber.onNext(itemId)
            }

            override fun onMenuItemReselect(itemId: Int, position: Int) {
            }
        })

        subscriber.add(object : MainThreadSubscription() {
            override fun onUnsubscribe() {
                bottomNavigation.setOnMenuItemClickListener(null)
            }
        })
    }

}