package io.wookoo.flyticketssearch.network.dtos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TicketOfferDTO(

    @Json(name = "id")
    val id: Int,

    @Json(name = "title")
    val title: String,

    @Json(name = "time_range")
    val timeRange: List<String>,

    @Json(name = "price")
    val price: PriceDTO
)
