package jis.lonepine.virnectexample.data.remote

import io.reactivex.rxjava3.core.Single
import jis.lonepine.virnectexample.data.entity.SearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface NaverApiService {
    @GET("/v1/search/shop.json")
    fun search(@Query("query") searchText:String): Single<SearchResult>
}