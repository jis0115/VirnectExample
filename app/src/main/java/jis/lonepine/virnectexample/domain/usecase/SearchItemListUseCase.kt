package jis.lonepine.virnectexample.domain.usecase

import jis.lonepine.virnectexample.domain.repository.SearchRepository

class SearchItemListUseCase(private val repository: SearchRepository) {
    fun searchItem(searchText:String) = repository.search(searchText)
}