package com.github.chuross.trancebaka.ui.activity.presenter

import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import com.github.chuross.library.mvp.presenter.ActivityPresenter
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.ui.activity.ScreenActivity
import com.github.chuross.trancebaka.ui.fragment.screen.HomeScreenFragment
import com.github.chuross.trancebaka.ui.fragment.screen.base.FragmentNavigator


class ScreenActivityPresenter(activity: ScreenActivity) : ActivityPresenter<ScreenActivity>(activity) {

    private val navigator by lazy { FragmentNavigator(view.supportFragmentManager, R.id.layout_screen) }

    override fun create(savedInstanceState: Bundle?) {
        super.create(savedInstanceState)
        navigator.launchScreen(HomeScreenFragment())
    }

    fun bindToolbar(toolbar: Toolbar) {
        val drawerToggle = ActionBarDrawerToggle(view, view.binding.layoutDrawer, toolbar, 0, 0).apply { isDrawerIndicatorEnabled = true }
        view.binding.layoutDrawer.removeDrawerListener(drawerToggle)
        view.binding.layoutDrawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }
}