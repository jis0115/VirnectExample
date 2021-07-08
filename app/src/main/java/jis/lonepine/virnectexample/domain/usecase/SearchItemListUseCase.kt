package jis.lonepine.virnectexample.domain.usecase

import jis.lonepine.virnectexample.domain.repository.SearchRepository

class SearchItemListUseCase(private val repository: SearchRepository) {
    fun searchItem(searchText:String,display:Int=100,start:Int=1) = repository.search(searchText,display, start)
}