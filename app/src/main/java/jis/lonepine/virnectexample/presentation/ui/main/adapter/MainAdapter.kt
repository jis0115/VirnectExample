package jis.lonepine.virnectexample.presentation.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.virnectexample.data.entity.Item
import jis.lonepine.virnectexample.databinding.HolderSearchItemBinding
import jis.lonepine.virnectexample.presentation.ui.main.adapter.holder.SearchItemHolder

class MainAdapter: RecyclerView.Adapter<SearchItemHolder>() {
    private val diffUtil = AsyncListDiffer(this,SearchResultDiffUtil())
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchItemHolder {
        return SearchItemHolder(HolderSearchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SearchItemHolder, position: Int) {
        holder.bind(diffUtil.currentList[position])
    }

    override fun getItemCount(): Int {
        return diffUtil.currentList.size
    }

    fun updateList(searchList:List<Item>)
    {
        diffUtil.submitList(searchList)
    }
}

@BindingAdapter("setSearchList")
fun setSearchList(recyclerView: RecyclerView,searchList:List<Item>){
    if (recyclerView.adapter == null){
        recyclerView.adapter = MainAdapter()
    }
    (recyclerView.adapter as? MainAdapter)?.updateList(searchList)
}