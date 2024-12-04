package io.wookoo.flyticketssearch.domain.models

data class TicketOfferModel(
    val id: Int,
    val title: String,
    val timeRange: List<String>,
    val price: PriceModel
)
