package io.wookoo.flyticketssearch.data.repo

import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.domain.models.UserFromModel
import io.wookoo.flyticketssearch.domain.repo.IFlightDatabase
import io.wookoo.flyticketssearch.domain.repo.IMasterRepository
import io.wookoo.flyticketssearch.domain.repo.INetworkApi
import kotlinx.coroutines.flow.Flow

class MasterRepositoryImpl(
    private val networkApi: INetworkApi,
    private val database: IFlightDatabase
) : IMasterRepository {
    override fun getAllOffers(): Flow<List<OfferModel>> {
        return networkApi.getAllOffers()
    }

    override suspend fun insertUserInfo(userInput: String) {
        database.insertUserInfo(userInput)
    }

    override fun getUserInfo(): Flow<UserFromModel> {
        return database.getUserInfo()
    }
}
