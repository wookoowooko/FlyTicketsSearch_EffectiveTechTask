package io.wookoo.flyticketssearch.network.dtos.info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HandLuggageDTO(

    @Json(name = "has_hand_luggage")
    val hasHandLuggage: Boolean,

    @Json(name = "size")
    val size: String? = null // Nullable because some tickets might not include a size.
)
