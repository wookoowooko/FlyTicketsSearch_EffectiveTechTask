package io.wookoo.flyticketssearch.domain.models.info

import io.wookoo.flyticketssearch.domain.models.PriceModel

data class LuggageModel(
    val hasLuggage: Boolean,
    val price: PriceModel? = null // Nullable because some tickets might not have luggage price.
)
