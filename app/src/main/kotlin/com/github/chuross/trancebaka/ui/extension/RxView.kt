package com.github.chuross.trancebaka.ui.extension

import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.github.chuross.trancebaka.ui.rx.BottomMenuItemSelectOnSubscribe
import rx.Observable


fun BottomNavigationBar.menuItemSelected(): Observable<Int> = Observable.create(BottomMenuItemSelectOnSubscribe(this))