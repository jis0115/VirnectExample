package jis.lonepine.virnectexample.presentation.ui.main.adapter

import androidx.recyclerview.widget.DiffUtil
import jis.lonepine.virnectexample.data.entity.Item

class SearchResultDiffUtil:DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}