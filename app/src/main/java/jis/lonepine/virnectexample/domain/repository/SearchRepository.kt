package jis.lonepine.virnectexample.domain.repository

import io.reactivex.rxjava3.core.Single
import jis.lonepine.virnectexample.data.datasource.SearchDataSource
import jis.lonepine.virnectexample.data.entity.SearchResult
import jis.lonepine.virnectexample.data.remote.NaverApiService

class SearchRepository(private val api:NaverApiService): SearchDataSource {
    override fun search(searchText: String,display:Int,start:Int): Single<SearchResult> {
        return api.search(searchText,display, start)
    }
}