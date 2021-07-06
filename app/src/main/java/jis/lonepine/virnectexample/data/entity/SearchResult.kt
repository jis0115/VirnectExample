package jis.lonepine.virnectexample.data.entity

data class SearchResult(
    val display: Int,
    val items: List<Item>,
    val lastBuildDate: String,
    val start: Int,
    val total: Int
)