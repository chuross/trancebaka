package com.github.chuross.trancebaka.ui.list

import android.content.Context
import android.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.chuross.recyclerviewadapters.ItemAdapter
import com.github.chuross.trancebaka.R
import com.github.chuross.trancebaka.databinding.AdapterTextBinding


class TextItemAdapter(context: Context) : ItemAdapter<Any, BindingViewHolder<AdapterTextBinding>>(context) {

    override fun getAdapterId(): Int = R.layout.adapter_text

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<AdapterTextBinding> {
        return BindingViewHolder(DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_text, parent, false))
    }

    override fun onBindViewHolder(viewHolder: BindingViewHolder<AdapterTextBinding>, viewType: Int) {
        viewHolder.binding.text.text = get(viewHolder.adapterPosition).toString()
    }


}