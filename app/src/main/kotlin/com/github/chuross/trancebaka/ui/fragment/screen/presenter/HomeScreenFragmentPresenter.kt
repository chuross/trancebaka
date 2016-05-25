package com.github.chuross.trancebaka.ui.fragment.screen.presenter

import android.os.Bundle
import com.github.chuross.library.mvp.presenter.SupportFragmentPresenter
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.ui.fragment.module.HomeFragment
import com.github.chuross.trancebaka.ui.fragment.screen.HomeScreenFragment


class HomeScreenFragmentPresenter(fragment: HomeScreenFragment) : SupportFragmentPresenter<HomeScreenFragment>(fragment) {

    override fun viewCreated(savedInstanceState: Bundle?) {
        super.viewCreated(savedInstanceState)

        view.childFragmentManager.beginTransaction().apply {
            replace(R.id.container, HomeFragment())
        }.commit()
    }
}