package com.github.chuross.trancebaka.ui.activity

import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import com.github.chuross.library.mvp.view.activity.PresentationActivity
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.databinding.ActivityScreenBinding
import com.github.chuross.trancebaka.ui.activity.presenter.ScreenActivityPresenter
import com.github.chuross.trancebaka.ui.fragment.screen.HomeScreenFragment
import com.github.chuross.trancebaka.ui.fragment.screen.base.FragmentNavigator


class ScreenActivity : PresentationActivity<ScreenActivityPresenter, ActivityScreenBinding>() {

    private val navigator by lazy { FragmentNavigator(supportFragmentManager, R.id.layout_screen) }


    override fun getLayoutResourceId(): Int = R.layout.activity_screen

    override fun createPresenter(): ScreenActivityPresenter = ScreenActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigator.launchScreen(HomeScreenFragment())
    }

    fun bindToolbar(toolbar: Toolbar) {
        val drawerToggle = ActionBarDrawerToggle(this, binding.layoutDrawer, toolbar, 0, 0).apply { isDrawerIndicatorEnabled = true }
        binding.layoutDrawer.removeDrawerListener(drawerToggle)
        binding.layoutDrawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }
}