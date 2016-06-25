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
import com.github.chuross.trancebaka.ui.fragment.screen.presenter.HomeScreenFragmentPresenter
import com.trello.rxlifecycle.FragmentEvent
import rx.functions.Action1


class HomeScreenFragment : BasePresentationFragment<HomeScreenFragmentPresenter, FragmentHomeScreenBinding>(), ScreenFragment {

    override val self: Fragment = this
    override val screen: Screen = ApplicationScreen.HOME
    override val identity: String = ApplicationScreen.HOME.name


    override fun getLayoutResourceId(): Int = R.layout.fragment_home_screen

    override fun createPresenter(): HomeScreenFragmentPresenter = HomeScreenFragmentPresenter(this)

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        presenter.replaceContainer(R.id.menu_item_home)
        binding.bottomNavigation
                .menuItemSelected()
                .compose(bindUntilEvent<Int>(FragmentEvent.DESTROY_VIEW))
                .sync()
                .execute(Action1 {
                    presenter.replaceContainer(it)
                })
    }
}