package io.wookoo.flyticketssearch.domain.models.info

import io.wookoo.flyticketssearch.domain.models.PriceModel

data class TicketModel(
    val id: Long,
    val badge: String? = null,
    val price: PriceModel,
    val providerName: String,
    val company: String,
    val departure: LocationModel,
    val arrival: LocationModel,
    val hasTransfer: Boolean,
    val hasVisaTransfer: Boolean,
    val luggage: LuggageModel,
    val handLuggage: HandLuggageModel,
    val isReturnable: Boolean,
    val isExchangable: Boolean
)
