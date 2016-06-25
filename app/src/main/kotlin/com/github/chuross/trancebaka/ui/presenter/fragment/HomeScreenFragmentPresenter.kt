package com.github.chuross.trancebaka.ui.presenter.fragment

import android.support.v4.app.Fragment
import com.github.chuross.library.mvp.presenter.SupportFragmentPresenter
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.ui.fragment.module.CategoryFragment
import com.github.chuross.trancebaka.ui.fragment.module.HomeFragment
import com.github.chuross.trancebaka.ui.fragment.screen.HomeScreenFragment


class HomeScreenFragmentPresenter(fragment: HomeScreenFragment) : SupportFragmentPresenter<HomeScreenFragment>(fragment) {

    fun replaceContainer(menuItemId: Int) {
        when (menuItemId) {
            R.id.menu_item_home -> replaceContainer(HomeFragment())
            R.id.menu_item_category -> replaceContainer(CategoryFragment())
        }
    }

    private fun replaceContainer(fragment: Fragment) {
        view.childFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
        }.commit()
    }

}