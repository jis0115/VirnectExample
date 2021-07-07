package jis.lonepine.virnectexample.presentation.ui.main.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.virnectexample.data.entity.Item
import jis.lonepine.virnectexample.databinding.HolderSearchItemBinding
import jis.lonepine.virnectexample.presentation.ui.main.viewmodel.MainViewModel

class SearchItemHolder(private val binding:HolderSearchItemBinding,private val mainViewModel: MainViewModel):RecyclerView.ViewHolder(binding.root) {
    fun bind(item:Item){
        binding.item = item
        binding.mainViewModel = mainViewModel
    }
}