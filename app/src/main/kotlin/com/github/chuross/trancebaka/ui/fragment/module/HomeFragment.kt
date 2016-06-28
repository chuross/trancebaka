package com.github.chuross.trancebaka.ui.fragment.module

import android.os.Bundle
import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.LinearLayoutManager
import com.github.chuross.recyclerviewadapters.CompositeRecyclerAdapter
import com.github.chuross.recyclerviewadapters.ViewItem
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.databinding.FragmentModuleHomeBinding
import com.github.chuross.trancebaka.ui.fragment.common.BasePresentationFragment
import com.github.chuross.trancebaka.ui.list.ListSectionViewItem
import com.github.chuross.trancebaka.ui.presenter.fragment.HomeFragmentPresenter


class HomeFragment : BasePresentationFragment<HomeFragmentPresenter, FragmentModuleHomeBinding>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_module_home

    override fun createPresenter(): HomeFragmentPresenter = HomeFragmentPresenter(this)

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        binding.toolbar.title = getString(R.string.app_name)
        binding.toolbar.navigationIcon = DrawerArrowDrawable(activity.applicationContext)

        binding.list.layoutManager = LinearLayoutManager(activity)
        binding.list.adapter = CompositeRecyclerAdapter().apply {
            add(ViewItem(activity, R.layout.view_quick_play))
            add(ListSectionViewItem(activity, getString(R.string.home_home_section_recently_play_track)))
        }
    }
}