package com.github.chuross.trancebaka.ui.fragment.module.presenter

import android.os.Bundle
import com.github.chuross.library.mvp.presenter.SupportFragmentPresenter
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.ui.fragment.module.HomeFragment


class HomeFragmentPresenter(fragment: HomeFragment) : SupportFragmentPresenter<HomeFragment>(fragment) {

    override fun viewCreated(savedInstanceState: Bundle?) {
        super.viewCreated(savedInstanceState)

        view.binding.toolbar.title = view.getString(R.string.app_name)
    }
}