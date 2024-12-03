package io.wookoo.flyticketssearch.network.dtos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OfferResponse(
    @Json(name = "offers")
    val offers: List<OffersDTO>
)

@JsonClass(generateAdapter = true)
data class OffersDTO(

    @Json(name = "id")
    val id: Long,

    @Json(name = "title")
    val title: String,

    @Json(name = "town")
    val town: String,

    @Json(name = "price")
    val price: PriceDTO
)

@JsonClass(generateAdapter = true)
data class PriceDTO(

    @Json(name = "value")
    val value: Int
)
