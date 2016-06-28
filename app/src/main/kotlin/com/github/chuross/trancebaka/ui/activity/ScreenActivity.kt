package com.github.chuross.trancebaka.ui.activity

import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.databinding.ActivityScreenBinding
import com.github.chuross.trancebaka.ui.activity.common.BasePresentationActivity
import com.github.chuross.trancebaka.ui.fragment.common.FragmentNavigator
import com.github.chuross.trancebaka.ui.presenter.activity.ScreenActivityPresenter


class ScreenActivity : BasePresentationActivity<ScreenActivityPresenter, ActivityScreenBinding>() {

    val navigator by lazy { FragmentNavigator(supportFragmentManager, R.id.layout_screen) }


    override fun getLayoutResourceId(): Int = R.layout.activity_screen

    override fun createPresenter(): ScreenActivityPresenter = ScreenActivityPresenter(this)

    override fun onBackPressed() {
        if (!presenter.backPress()) super.onBackPressed()
    }
}