package com.github.chuross.trancebaka.ui.list

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.chuross.recyclerviewadapters.ViewItem
import java.util.*


abstract class BindableViewItem<BINDING : ViewDataBinding>(context: Context, layoutResourceId: Int) : ViewItem(context, layoutResourceId) {

    val layoutResourceId: Int
    val bindingMap = WeakHashMap<ViewHolder, BINDING>()

    init {
        this.layoutResourceId = layoutResourceId
    }

    abstract fun onBindViewHolder(binding: BINDING?, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder? {
        val binding: BINDING = DataBindingUtil.inflate(LayoutInflater.from(context), layoutResourceId, parent, false)
        return object : ViewHolder(binding.root) {}.apply { bindingMap.put(this, binding) }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        onBindViewHolder(bindingMap[holder], position)
    }
}