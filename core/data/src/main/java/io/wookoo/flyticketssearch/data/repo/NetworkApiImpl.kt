package io.wookoo.flyticketssearch.data.repo

import io.wookoo.flyticketssearch.data.mappers.toOfferModel
import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.domain.repo.INetworkApi
import io.wookoo.flyticketssearch.logger.MyLogger.logger
import io.wookoo.flyticketssearch.network.IOffersApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NetworkApiImpl(
    private val api: io.wookoo.flyticketssearch.network.IOffersApi
) : INetworkApi {
    override fun getAllOffers(): Flow<List<OfferModel>> {
        logger.info("TAG", "getAllOffers")
        return flow {
            api.getOffers()
                .asFlow()
                .collect { response ->
                    emit(response.data.map { it.toOfferModel() })
                }
        }
    }
}

