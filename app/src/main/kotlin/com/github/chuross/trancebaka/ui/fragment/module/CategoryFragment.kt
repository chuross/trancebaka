package com.github.chuross.trancebaka.ui.fragment.module

import android.os.Bundle
import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.LinearLayoutManager
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.application.Category
import com.github.chuross.trancebaka.databinding.FragmentModuleCategoryBinding
import com.github.chuross.trancebaka.ui.fragment.common.BasePresentationFragment
import com.github.chuross.trancebaka.ui.list.TextItemAdapter
import com.github.chuross.trancebaka.ui.presenter.fragment.CategoryFragmentPresenter


class CategoryFragment : BasePresentationFragment<CategoryFragmentPresenter, FragmentModuleCategoryBinding>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_module_category

    override fun createPresenter(): CategoryFragmentPresenter = CategoryFragmentPresenter(this)

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        binding.toolbar.title = getString(R.string.menu_category)
        binding.toolbar.navigationIcon = DrawerArrowDrawable(activity.applicationContext)
        binding.toolbar.setNavigationOnClickListener { screenActivity.presenter.toggleDrawer() }

        binding.list.layoutManager = LinearLayoutManager(activity)
        binding.list.adapter = TextItemAdapter(activity).apply {
            addAll(Category.values().map { it.displayName })
            setOnItemClickListener { viewHolder, position, item ->
                // TODO
            }
        }
    }
}