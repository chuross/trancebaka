package com.github.chuross.trancebaka.ui.extension

import com.github.chuross.trancebaka.ui.rx.BottomMenuItemSelectOnSubscribe
import it.sephiroth.android.library.bottomnavigation.BottomNavigation
import rx.Observable

fun BottomNavigation.menuItemSelected(): Observable<Int> = Observable.create(BottomMenuItemSelectOnSubscribe(this))