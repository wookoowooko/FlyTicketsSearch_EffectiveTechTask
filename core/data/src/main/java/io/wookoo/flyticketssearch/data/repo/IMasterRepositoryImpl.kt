package io.wookoo.flyticketssearch.data.repo

import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.domain.repo.IMasterRepository
import io.wookoo.flyticketssearch.domain.repo.INetworkApi
import io.wookoo.flyticketssearch.logger.MyLogger.logger
import kotlinx.coroutines.flow.Flow

class MasterRepositoryImpl(
    private val networkApi: INetworkApi
) : IMasterRepository {
    override fun getAllOffers(): Flow<List<OfferModel>> {
        logger.info("API", "getAllOffers in data master repository")
        return networkApi.getAllOffers()
    }
}