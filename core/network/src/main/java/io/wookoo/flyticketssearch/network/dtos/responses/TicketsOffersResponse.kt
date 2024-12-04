package io.wookoo.flyticketssearch.network.dtos.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.wookoo.flyticketssearch.network.dtos.TicketOfferDTO

@JsonClass(generateAdapter = true)
data class TicketsOffersResponse(
    @Json(name = "tickets_offers")
    val ticketsOffers: List<TicketOfferDTO>
)
