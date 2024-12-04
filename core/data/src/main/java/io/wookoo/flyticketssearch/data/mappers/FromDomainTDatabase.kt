package io.wookoo.flyticketssearch.data.mappers

import io.wookoo.flyticketssearch.domain.models.PriceModel
import io.wookoo.flyticketssearch.network.dtos.PriceDTO

fun PriceDTO.toPriceModel(): PriceModel {
    return PriceModel(
        value = value
    )
}
