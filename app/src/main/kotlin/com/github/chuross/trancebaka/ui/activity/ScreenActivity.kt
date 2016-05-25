package com.github.chuross.trancebaka.ui.activity

import android.support.v7.widget.Toolbar
import com.github.chuross.library.mvp.view.activity.PresentationActivity
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.databinding.ActivityScreenBinding
import com.github.chuross.trancebaka.ui.activity.presenter.ScreenActivityPresenter
import com.github.chuross.trancebaka.ui.fragment.screen.base.FragmentNavigator


class ScreenActivity : PresentationActivity<ScreenActivityPresenter, ActivityScreenBinding>() {

    val navigator by lazy { FragmentNavigator(supportFragmentManager, R.id.layout_screen) }


    override fun getLayoutResourceId(): Int = R.layout.activity_screen

    override fun createPresenter(): ScreenActivityPresenter = ScreenActivityPresenter(this)

    fun bindToolbar(toolbar: Toolbar) {
        presenter.bindToolbar(toolbar)
    }
}