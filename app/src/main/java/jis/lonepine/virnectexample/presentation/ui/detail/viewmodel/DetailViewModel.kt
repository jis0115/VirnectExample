package jis.lonepine.virnectexample.presentation.ui.detail.viewmodel

import androidx.lifecycle.LiveData
import jis.lonepine.virnectexample.data.entity.Item
import jis.lonepine.virnectexample.presentation.base.DisposableViewModel
import jis.lonepine.virnectexample.presentation.base.SingleLiveEvent

class DetailViewModel:DisposableViewModel() {
    private val _openWebBrowser = SingleLiveEvent<String>()
    val openWebBrowser:LiveData<String> = _openWebBrowser
    fun goNaverShopping(item: Item){
        _openWebBrowser.value = item.link
    }
}