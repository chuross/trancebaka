package com.github.chuross.trancebaka.ui.fragment.screen

import android.os.Bundle
import android.support.v4.app.Fragment
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.application.ApplicationScreen
import com.github.chuross.trancebaka.databinding.FragmentHomeScreenBinding
import com.github.chuross.trancebaka.ui.extension.menuItemSelected
import com.github.chuross.trancebaka.ui.fragment.base.BasePresentationFragment
import com.github.chuross.trancebaka.ui.fragment.screen.base.Screen
import com.github.chuross.trancebaka.ui.fragment.screen.base.ScreenFragment
import com.github.chuross.trancebaka.ui.fragment.screen.presenter.HomeScreenFragmentPresenter


class HomeScreenFragment : BasePresentationFragment<HomeScreenFragmentPresenter, FragmentHomeScreenBinding>(), ScreenFragment {

    override val self: Fragment = this
    override val screen: Screen = ApplicationScreen.HOME
    override val identity: String = ApplicationScreen.HOME.name


    override fun getLayoutResourceId(): Int = R.layout.fragment_home_screen

    override fun createPresenter(): HomeScreenFragmentPresenter = HomeScreenFragmentPresenter(this)

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        presenter.replaceContainer(R.id.menu_item_home)
        subscriptions.add(binding.bottomNavigation.menuItemSelected().subscribe() {
            presenter.replaceContainer(it)
        })
    }
}