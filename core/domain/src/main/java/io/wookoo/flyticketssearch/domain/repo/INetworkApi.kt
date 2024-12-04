package io.wookoo.flyticketssearch.domain.repo

import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.domain.models.TicketOfferModel
import kotlinx.coroutines.flow.Flow

interface INetworkApi {
    fun getAllOffers(): Flow<List<OfferModel>>
    fun getAllTicketsOffers(): Flow<List<TicketOfferModel>>
}
