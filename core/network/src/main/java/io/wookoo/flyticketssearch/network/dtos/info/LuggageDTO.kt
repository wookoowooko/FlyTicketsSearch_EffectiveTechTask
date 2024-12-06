package io.wookoo.flyticketssearch.network.dtos.info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.wookoo.flyticketssearch.network.dtos.PriceDTO

@JsonClass(generateAdapter = true)
data class LuggageDTO(

    @Json(name = "has_luggage")
    val hasLuggage: Boolean,
    val price: PriceDTO? = null
)
