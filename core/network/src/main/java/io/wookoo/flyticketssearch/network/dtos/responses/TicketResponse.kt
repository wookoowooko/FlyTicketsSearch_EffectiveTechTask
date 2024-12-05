package io.wookoo.flyticketssearch.network.dtos.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import io.wookoo.flyticketssearch.network.dtos.info.TicketDTO

@JsonClass(generateAdapter = true)
data class TicketResponse(

    @Json(name = "tickets")
    val tickets: List<TicketDTO>
)
