package com.github.chuross.trancebaka.ui.presenter.fragment

import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.github.chuross.library.mvp.presenter.SupportFragmentPresenter
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.ui.fragment.module.CategoryFragment
import com.github.chuross.trancebaka.ui.fragment.module.HomeFragment
import com.github.chuross.trancebaka.ui.fragment.screen.HomeScreenFragment


class HomeScreenFragmentPresenter(fragment: HomeScreenFragment) : SupportFragmentPresenter<HomeScreenFragment>(fragment) {

    companion object {
        private fun getBottomNavigationItem(menu: HomeMenu) = BottomNavigationItem(menu.drawableResourceId, menu.titleResourceId)
    }


    val bottomNavigationItems = listOf(
            getBottomNavigationItem(HomeMenu.HOME),
            getBottomNavigationItem(HomeMenu.PLAYLIST),
            getBottomNavigationItem(HomeMenu.CATEGORY)
    )


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

    enum class HomeMenu(val drawableResourceId: Int, val titleResourceId: Int) {
        HOME(R.mipmap.ic_home_white_24dp, R.string.menu_home),
        PLAYLIST(R.mipmap.ic_queue_music_white_24dp, R.string.menu_playlist),
        CATEGORY(R.mipmap.ic_apps_white_24dp, R.string.menu_category)
    }

}