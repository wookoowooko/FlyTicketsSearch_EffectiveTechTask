package io.wookoo.flyticketssearch.domain.repo

import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.domain.models.UserFromModel
import kotlinx.coroutines.flow.Flow

interface IMasterRepository {
    fun getAllOffers(): Flow<List<OfferModel>>
    fun getUserInfo(): Flow<UserFromModel>
    suspend fun saveUserInfo(userInfo: UserFromModel)
}
