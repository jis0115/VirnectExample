package jis.lonepine.virnectexample.presentation.ui.main.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.virnectexample.data.entity.Item
import jis.lonepine.virnectexample.databinding.HolderSearchItemBinding

class SearchItemHolder(private val binding:HolderSearchItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(item:Item){
        binding.item = item
    }
}