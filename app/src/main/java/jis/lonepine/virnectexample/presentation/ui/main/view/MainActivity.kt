package jis.lonepine.virnectexample.presentation.ui.main.view

import android.content.Intent
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jis.lonepine.virnectexample.R
import jis.lonepine.virnectexample.databinding.ActivityMainBinding
import jis.lonepine.virnectexample.presentation.base.BindingActivity
import jis.lonepine.virnectexample.presentation.extension.observe
import jis.lonepine.virnectexample.presentation.ui.detail.view.DetailActivity
import jis.lonepine.virnectexample.presentation.ui.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel:MainViewModel by viewModel()
    override fun initView() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = title

        binding.viewModel = mainViewModel.apply {
            observe(showDetail){
                binding.searchView.clearFocus()
                startActivity(Intent(this@MainActivity,DetailActivity::class.java).apply {
                    putExtra("item",it!!)
                })
            }
        }

        binding.searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    mainViewModel.searchItem(it)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        binding.recyclerView.addOnScrollListener(object:RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                mainViewModel.loadMore((recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition())
            }

        })

    }

}