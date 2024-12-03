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

// {
//    "offers": [
//    {"id": 1, "title": "Die Antwoord", "town": "Будапешт", "price": {"value": 5000}},
//    {"id": 2, "title": "Socrat&Lera", "town": "Санкт-Петербург", "price": {"value": 1999}},
//    {"id": 3, "title": "Лампабикт", "town": "Москва", "price": {"value": 2390}}
//    ]
// }
