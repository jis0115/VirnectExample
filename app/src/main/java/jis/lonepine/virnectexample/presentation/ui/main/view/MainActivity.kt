package jis.lonepine.virnectexample.presentation.ui.main.view

import android.content.Intent
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
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

    }

}