package jis.lonepine.virnectexample.presentation.ui.detail.view

import android.util.Log
import jis.lonepine.virnectexample.R
import jis.lonepine.virnectexample.data.entity.Item
import jis.lonepine.virnectexample.databinding.ActivityDetailBinding
import jis.lonepine.virnectexample.presentation.base.BindingActivity

class DetailActivity:BindingActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    override fun initView() {
        val item = intent.getParcelableExtra<Item>("item")
        Log.e("jis","item > $item")
    }
}