package io.wookoo.flyticketssearch.network

import io.wookoo.flyticketssearch.network.dtos.OfferResponse
import ir.logicbase.mockfit.Mock
import retrofit2.Response
import retrofit2.http.GET

interface IOffersApi {
    @Mock("offers.json")
    @GET("list")
    suspend fun getOffers(): Response<OfferResponse>
}
