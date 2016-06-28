package com.github.chuross.trancebaka.ui.presenter.activity

import android.os.Bundle
import android.support.v4.view.GravityCompat
import com.github.chuross.library.mvp.presenter.ActivityPresenter
import com.github.chuross.trancebaka.ui.activity.ScreenActivity
import com.github.chuross.trancebaka.ui.fragment.screen.HomeScreenFragment


class ScreenActivityPresenter(activity: ScreenActivity) : ActivityPresenter<ScreenActivity>(activity) {

    val isDrawerOpen: Boolean get() = view.binding.layoutDrawer.isDrawerOpen(GravityCompat.START)

    override fun create(savedInstanceState: Bundle?) {
        super.create(savedInstanceState)
        view.navigator.launchScreen(HomeScreenFragment())
    }

    override fun backPress(): Boolean {
        return if (isDrawerOpen) true.apply { closeDrawer() } else super.backPress()
    }

    fun toggleDrawer() {
        if (isDrawerOpen) closeDrawer() else openDrawer()
    }

    fun openDrawer() = view.binding.layoutDrawer.openDrawer(GravityCompat.START)

    fun closeDrawer() = view.binding.layoutDrawer.closeDrawer(GravityCompat.START)
}