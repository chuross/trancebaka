package com.github.chuross.trancebaka.ui.list

import android.content.Context
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.databinding.ViewListSectionBinding


class ListSectionViewItem(context: Context, private val title: String) : BindableViewItem<ViewListSectionBinding>(context, R.layout.view_list_section) {

    override fun onBindViewHolder(binding: ViewListSectionBinding?, position: Int) {
        binding?.title = title
    }

}