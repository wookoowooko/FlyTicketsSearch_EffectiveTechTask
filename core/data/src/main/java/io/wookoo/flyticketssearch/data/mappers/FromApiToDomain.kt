package io.wookoo.flyticketssearch.data.mappers

import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.network.dtos.OffersDTO

fun OffersDTO.toOfferModel(): OfferModel {
    return OfferModel(
        id = id,
        title = title,
        town = town,
        price = price.toPriceModel()
    )
}
