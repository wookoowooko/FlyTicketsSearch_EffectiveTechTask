package io.wookoo.flyticketssearch.data.mappers

import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.domain.models.PriceModel
import io.wookoo.flyticketssearch.domain.models.TicketOfferModel
import io.wookoo.flyticketssearch.network.dtos.OfferDTO
import io.wookoo.flyticketssearch.network.dtos.PriceDTO
import io.wookoo.flyticketssearch.network.dtos.TicketOfferDTO

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
