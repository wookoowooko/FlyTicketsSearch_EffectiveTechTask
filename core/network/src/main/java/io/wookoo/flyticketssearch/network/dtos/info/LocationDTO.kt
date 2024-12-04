package io.wookoo.flyticketssearch.network.dtos.info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationDTO(
    @Json(name = "town")
    val town: String,

    @Json(name = "date")
    val date: String,

    @Json(name = "airport")
    val airport: String
)
