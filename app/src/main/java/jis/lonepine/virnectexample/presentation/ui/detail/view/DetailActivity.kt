package jis.lonepine.virnectexample.presentation.ui.detail.view

import android.content.Intent
import android.net.Uri
import android.util.Log
import jis.lonepine.virnectexample.R
import jis.lonepine.virnectexample.data.entity.Item
import jis.lonepine.virnectexample.databinding.ActivityDetailBinding
import jis.lonepine.virnectexample.presentation.base.BindingActivity
import jis.lonepine.virnectexample.presentation.extension.getScreenWidth
import jis.lonepine.virnectexample.presentation.extension.observe
import jis.lonepine.virnectexample.presentation.ui.detail.viewmodel.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity:BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val viewModel:DetailViewModel by viewModel()
    override fun initView() {
        setSupportActionBar(findViewById(R.id.detail_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.viewModel = viewModel.apply {
            observe(openWebBrowser){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it!!)))
            }
        }
        val item = intent.getParcelableExtra<Item>("item")
        binding.item = item

        binding.appBar.layoutParams.height = getScreenWidth()

        Log.e("jis","item > $item")
    }
}