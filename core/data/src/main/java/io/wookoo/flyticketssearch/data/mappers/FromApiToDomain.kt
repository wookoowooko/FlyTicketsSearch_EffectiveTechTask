package io.wookoo.flyticketssearch.data.mappers

import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.domain.models.PriceModel
import io.wookoo.flyticketssearch.domain.models.TicketOfferModel
import io.wookoo.flyticketssearch.domain.models.info.HandLuggageModel
import io.wookoo.flyticketssearch.domain.models.info.LocationModel
import io.wookoo.flyticketssearch.domain.models.info.LuggageModel
import io.wookoo.flyticketssearch.domain.models.info.TicketModel
import io.wookoo.flyticketssearch.network.dtos.OfferDTO
import io.wookoo.flyticketssearch.network.dtos.PriceDTO
import io.wookoo.flyticketssearch.network.dtos.TicketOfferDTO
import io.wookoo.flyticketssearch.network.dtos.info.HandLuggageDTO
import io.wookoo.flyticketssearch.network.dtos.info.LocationDTO
import io.wookoo.flyticketssearch.network.dtos.info.LuggageDTO
import io.wookoo.flyticketssearch.network.dtos.info.TicketDTO

fun OfferDTO.toOfferModel(): OfferModel {
    return OfferModel(
        id = id,
        title = title,
        town = town,
        price = price.toPriceModel()
    )
}

private fun PriceDTO.toPriceModel(): PriceModel {
    return PriceModel(
        value = value
    )
}

fun TicketOfferDTO.toTicketOfferModel(): TicketOfferModel {
    return TicketOfferModel(
        id = id,
        title = title,
        timeRange = timeRange,
        price = price.toPriceModel()
    )
}

fun TicketDTO.toTicketModel(): TicketModel {
    return TicketModel(
        id = id,
        badge = badge,
        price = price.toPriceModel(),
        providerName = providerName,
        company = company,
        departure = departure.toLocationModel(),
        arrival = arrival.toLocationModel(),
        hasTransfer = hasTransfer,
        hasVisaTransfer = hasVisaTransfer,
        luggage = luggage.toLuggageModel(),
        handLuggage = handLuggage.toHandLuggageModel(),
        isReturnable = isReturnable,
        isExchangable = isExchangable
    )
}

private fun LocationDTO.toLocationModel(): LocationModel {
    return LocationModel(
        town = town,
        date = date,
        airport = airport
    )
}

private fun LuggageDTO.toLuggageModel(): LuggageModel {
    return LuggageModel(
        hasLuggage = hasLuggage,
        price = price?.toPriceModel()
    )
}

private fun HandLuggageDTO.toHandLuggageModel(): HandLuggageModel {
    return HandLuggageModel(
        hasHandLuggage = hasHandLuggage,
        size = size
    )
}
