package jis.lonepine.virnectexample.presentation.ui.main.viewmodel

import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import jis.lonepine.virnectexample.data.entity.Item
import jis.lonepine.virnectexample.domain.usecase.SearchItemListUseCase
import jis.lonepine.virnectexample.presentation.base.DisposableViewModel
import jis.lonepine.virnectexample.presentation.base.NotNullMutableLiveData

class MainViewModel(
    private val searchItemListUseCase: SearchItemListUseCase
): DisposableViewModel() {
    private val _searchList = NotNullMutableLiveData(listOf<Item>())
    val searchList:LiveData<List<Item>> = _searchList
    fun searchItem(text:String){
        addDisposable(
            searchItemListUseCase.searchItem(text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.items.isNotEmpty()){
                        _searchList.value = it.items
                    }else
                    {
                        _searchList.value = listOf()
                    }
                },{
                    it.printStackTrace()
                })
        )
    }
}