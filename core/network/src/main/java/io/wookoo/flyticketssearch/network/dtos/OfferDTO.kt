package io.wookoo.flyticketssearch.network.dtos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OfferDTO(

    @Json(name = "id")
    val id: Long,

    @Json(name = "title")
    val title: String,

    @Json(name = "town")
    val town: String,

    @Json(name = "price")
    val price: PriceDTO
)
