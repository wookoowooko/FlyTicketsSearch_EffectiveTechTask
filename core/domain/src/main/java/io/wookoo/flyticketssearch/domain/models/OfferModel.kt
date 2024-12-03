package io.wookoo.flyticketssearch.domain.models

data class OfferModel(
    val id: Long,
    val title: String,
    val town: String,
    val price: PriceModel
)

data class PriceModel(
    val value: Int
)
