package io.wookoo.flyticketssearch.network

import io.wookoo.flyticketssearch.network.dtos.responses.OfferResponse
import io.wookoo.flyticketssearch.network.dtos.responses.TicketsOffersResponse
import ir.logicbase.mockfit.Mock
import retrofit2.Response
import retrofit2.http.GET

interface IFlyApi {
    @Mock("offers.json")
    @GET("list")
    suspend fun getOffers(): Response<OfferResponse>

    @Mock("offers_tickets.json")
    @GET("list2")
    suspend fun getTicketsOffers(): Response<TicketsOffersResponse>
}
