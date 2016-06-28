package com.github.chuross.trancebaka.ui.rx

import com.ashokvarma.bottomnavigation.BottomNavigationBar
import rx.Observable
import rx.Subscriber
import rx.android.MainThreadSubscription


class BottomMenuItemSelectOnSubscribe(private val bottomNavigation: BottomNavigationBar) : Observable.OnSubscribe<Int> {

    override fun call(subscriber: Subscriber<in Int>) {
        bottomNavigation.setTabSelectedListener(object : BottomNavigationBar.SimpleOnTabSelectedListener() {
            override fun onTabSelected(position: Int) {
                subscriber.onNext(position)
            }
        })
        subscriber.add(object : MainThreadSubscription() {
            override fun onUnsubscribe() {
                bottomNavigation.setTabSelectedListener(null)
            }
        })
    }

}