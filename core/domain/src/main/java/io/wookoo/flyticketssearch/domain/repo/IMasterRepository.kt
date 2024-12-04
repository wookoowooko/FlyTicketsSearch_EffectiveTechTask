package io.wookoo.flyticketssearch.domain.repo

import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.domain.models.TicketOfferModel
import io.wookoo.flyticketssearch.domain.models.UserFromModel
import kotlinx.coroutines.flow.Flow

interface IMasterRepository {
    fun getAllOffers(): Flow<List<OfferModel>>
    fun getAllTicketOffers(): Flow<List<TicketOfferModel>>
    fun getUserInfo(): Flow<UserFromModel>
    suspend fun saveUserInfo(userInfo: UserFromModel)
}
