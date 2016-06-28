package com.github.chuross.trancebaka.ui.fragment.screen

import android.os.Bundle
import android.support.v4.app.Fragment
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.application.ApplicationScreen
import com.github.chuross.trancebaka.databinding.FragmentHomeScreenBinding
import com.github.chuross.trancebaka.infrastructure.extension.sync
import com.github.chuross.trancebaka.ui.extension.menuItemSelected
import com.github.chuross.trancebaka.ui.fragment.common.BasePresentationFragment
import com.github.chuross.trancebaka.ui.fragment.common.Screen
import com.github.chuross.trancebaka.ui.fragment.common.ScreenFragment
import com.github.chuross.trancebaka.ui.presenter.fragment.HomeScreenFragmentPresenter
import com.trello.rxlifecycle.FragmentEvent
import com.trello.rxlifecycle.kotlin.bindUntilEvent
import rx.functions.Action1


class HomeScreenFragment : BasePresentationFragment<HomeScreenFragmentPresenter, FragmentHomeScreenBinding>(), ScreenFragment {

    override val self: Fragment = this
    override val screen: Screen = ApplicationScreen.HOME
    override val identity: String = ApplicationScreen.HOME.name


    override fun getLayoutResourceId(): Int = R.layout.fragment_home_screen

    override fun createPresenter(): HomeScreenFragmentPresenter = HomeScreenFragmentPresenter(this)

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        presenter.replaceContainer(HomeScreenFragmentPresenter.HomeMenu.HOME)

        presenter.bottomNavigationItems.forEach { binding.bottomNavigation.addItem(it) }
        binding.bottomNavigation.initialise()
        binding.bottomNavigation
                .menuItemSelected()
                .bindUntilEvent(this, FragmentEvent.DESTROY_VIEW)
                .sync()
                .execute(Action1 {
                    presenter.replaceContainer(HomeScreenFragmentPresenter.HomeMenu.values()[it])
                })
    }
}