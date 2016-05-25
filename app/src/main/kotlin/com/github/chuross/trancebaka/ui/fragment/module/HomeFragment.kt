package com.github.chuross.trancebaka.ui.fragment.module

import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.databinding.FragmentHomeBinding
import com.github.chuross.trancebaka.ui.fragment.base.BasePresentationFragment
import com.github.chuross.trancebaka.ui.fragment.module.presenter.HomeFragmentPresenter


class HomeFragment : BasePresentationFragment<HomeFragmentPresenter, FragmentHomeBinding>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_home

    override fun createPresenter(): HomeFragmentPresenter = HomeFragmentPresenter(this)

}