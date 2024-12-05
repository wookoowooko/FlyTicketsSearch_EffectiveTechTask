package io.wookoo.flyticketssearch.network.dtos.info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.wookoo.flyticketssearch.network.dtos.PriceDTO

@JsonClass(generateAdapter = true)
data class TicketDTO(
    @Json(name = "id")
    val id: Long,

    @Json(name = "badge")
    val badge: String? = null,

    @Json(name = "price")
    val price: PriceDTO,

    @Json(name = "provider_name")
    val providerName: String,

    @Json(name = "company")
    val company: String,

    @Json(name = "departure")
    val departure: LocationDTO,

    @Json(name = "arrival")
    val arrival: LocationDTO,

    @Json(name = "has_transfer")
    val hasTransfer: Boolean,

    @Json(name = "has_visa_transfer")
    val hasVisaTransfer: Boolean,

    @Json(name = "luggage")
    val luggage: LuggageDTO,

    @Json(name = "hand_luggage")
    val handLuggage: HandLuggageDTO,

    @Json(name = "is_returnable")
    val isReturnable: Boolean,

    @Json(name = "is_exchangable")
    val isExchangable: Boolean
)
