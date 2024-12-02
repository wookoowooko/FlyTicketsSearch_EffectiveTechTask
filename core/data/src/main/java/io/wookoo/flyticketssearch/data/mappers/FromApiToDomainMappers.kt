package io.wookoo.flyticketssearch.data.mappers

import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.domain.models.PriceModel
import io.wookoo.flyticketssearch.network.network.dtos.OffersDTO
import io.wookoo.flyticketssearch.network.network.dtos.PriceDTO

fun io.wookoo.flyticketssearch.network.network.dtos.OffersDTO.toOfferModel(): OfferModel {
    return OfferModel(
        id = id,
        title = title,
        town = town,
        price = price.toPriceModel()
    )
}
private fun io.wookoo.flyticketssearch.network.network.dtos.PriceDTO.toPriceModel(): PriceModel {
    return PriceModel(
        value = value
    )
}
