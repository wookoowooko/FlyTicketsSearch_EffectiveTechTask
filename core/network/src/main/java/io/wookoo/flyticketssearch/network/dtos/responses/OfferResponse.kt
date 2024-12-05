package io.wookoo.flyticketssearch.network.dtos.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.wookoo.flyticketssearch.network.dtos.OfferDTO

@JsonClass(generateAdapter = true)
data class OfferResponse(
    @Json(name = "offers")
    val offers: List<OfferDTO>
)
