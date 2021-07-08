package jis.lonepine.virnectexample.presentation.ui.main.viewmodel

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.virnectexample.data.entity.Item
import jis.lonepine.virnectexample.domain.usecase.SearchItemListUseCase
import jis.lonepine.virnectexample.presentation.base.DisposableViewModel
import jis.lonepine.virnectexample.presentation.base.NotNullMutableLiveData
import jis.lonepine.virnectexample.presentation.base.SingleLiveEvent

class MainViewModel(
    private val searchItemListUseCase: SearchItemListUseCase
): DisposableViewModel() {
    var searchText = ""
    var display = 100
    var startIdx = 1
    var isLoading = false

    private val _searchList = NotNullMutableLiveData(listOf<Item>())
    val searchList:LiveData<List<Item>> = _searchList
    fun searchItem(text:String){
        searchText = text
        startIdx = 1
        _searchList.value = listOf()
        callApi()
    }

    private fun callApi(){
        addDisposable(
            searchItemListUseCase.searchItem(searchText,display,startIdx)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { isLoading = false }
                .subscribe({
                    if (it.items.isNotEmpty()){
                        _searchList.value = mutableListOf<Item>().apply {
                            addAll(_searchList.value)
                            addAll(it.items)
                        }
                    }else
                    {
                        _searchList.value = listOf()
                    }
                },{
                    it.printStackTrace()
                })
        )
    }

    fun loadMore(visiblePosition:Int){
        if(visiblePosition == _searchList.value.size-1 && !isLoading){
            isLoading = true
            startIdx+=display
            callApi()
        }
    }

    private val _showDetail = SingleLiveEvent<Item>()
    val showDetail:LiveData<Item> = _showDetail
    fun itemTouched(item:Item){
        _showDetail.value = item
    }
}