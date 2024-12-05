package io.wookoo.flyticketssearch.network.dtos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PriceDTO(
    @Json(name = "value")
    val value: Int
)
