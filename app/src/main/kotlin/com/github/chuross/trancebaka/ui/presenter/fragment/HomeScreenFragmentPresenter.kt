package com.github.chuross.trancebaka.ui.presenter.fragment

import android.support.v4.app.Fragment
import com.github.chuross.library.mvp.presenter.SupportFragmentPresenter
import com.github.chuross.trancebaka.ui.HomeMenu
import com.github.chuross.trancebaka.ui.fragment.module.CategoryFragment
import com.github.chuross.trancebaka.ui.fragment.module.HomeFragment
import com.github.chuross.trancebaka.ui.fragment.screen.HomeScreenFragment


class HomeScreenFragmentPresenter(fragment: HomeScreenFragment) : SupportFragmentPresenter<HomeScreenFragment>(fragment) {

    fun replaceContainer(menu: HomeMenu) {
        when (menu) {
            HomeMenu.HOME -> replaceContainer(HomeFragment())
            HomeMenu.PLAYLIST -> null // TODO
            HomeMenu.CATEGORY -> replaceContainer(CategoryFragment())
        }
    }

    private fun replaceContainer(fragment: Fragment) {
        view.childFragmentManager.beginTransaction().apply {
            replace(view.binding.container.id, fragment)
        }.commit()
    }

}