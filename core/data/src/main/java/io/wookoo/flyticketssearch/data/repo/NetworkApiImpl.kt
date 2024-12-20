package io.wookoo.flyticketssearch.data.repo

import io.wookoo.flyticketssearch.data.mappers.toOfferModel
import io.wookoo.flyticketssearch.data.mappers.toTicketModel
import io.wookoo.flyticketssearch.data.mappers.toTicketOfferModel
import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.domain.models.TicketOfferModel
import io.wookoo.flyticketssearch.domain.models.info.TicketModel
import io.wookoo.flyticketssearch.domain.repo.INetworkApi
import io.wookoo.flyticketssearch.network.IFlyApi
import io.wookoo.flyticketssearch.network.dtos.responses.OfferResponse
import io.wookoo.flyticketssearch.network.dtos.responses.TicketsOffersResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NetworkApiImpl(
    private val api: IFlyApi,
    private val ioDispatcher: CoroutineDispatcher
) : INetworkApi {
    override fun getAllOffers(): Flow<List<OfferModel>> {
        return flow {
            api.getOffers()
                .asFlow()
                .collect { response: OfferResponse ->
                    emit(
                        response.offers.map {
                            it.toOfferModel()
                        }
                    )
                }
        }.flowOn(ioDispatcher)
    }

    override fun getAllTicketsOffers(): Flow<List<TicketOfferModel>> {
        return flow {
            api.getTicketsOffers()
                .asFlow()
                .collect { response: TicketsOffersResponse ->
                    emit(
                        response.ticketsOffers.map {
                            it.toTicketOfferModel()
                        }
                    )
                }
        }.flowOn(ioDispatcher)
    }

    override fun getTickets(): Flow<List<TicketModel>> {
        return flow {
            api.getTickets()
                .asFlow()
                .collect { response ->
                    emit(
                        response.tickets.map {
                            it.toTicketModel()
                        }
                    )
                }
        }.flowOn(ioDispatcher)
    }
}
