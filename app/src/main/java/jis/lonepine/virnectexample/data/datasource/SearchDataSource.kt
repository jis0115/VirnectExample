package jis.lonepine.virnectexample.data.datasource

import io.reactivex.rxjava3.core.Single
import jis.lonepine.virnectexample.data.entity.SearchResult

interface SearchDataSource {
    fun search(searchText: String,display:Int,start:Int): Single<SearchResult>

}