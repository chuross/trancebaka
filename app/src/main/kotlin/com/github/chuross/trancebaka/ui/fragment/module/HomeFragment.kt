package com.github.chuross.trancebaka.ui.fragment.module

import android.os.Bundle
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.databinding.FragmentModuleHomeBinding
import com.github.chuross.trancebaka.ui.fragment.base.BasePresentationFragment
import com.github.chuross.trancebaka.ui.fragment.module.presenter.HomeFragmentPresenter


class HomeFragment : BasePresentationFragment<HomeFragmentPresenter, FragmentModuleHomeBinding>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_module_home

    override fun createPresenter(): HomeFragmentPresenter = HomeFragmentPresenter(this)

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        binding.toolbar.title = getString(R.string.app_name)
    }
}