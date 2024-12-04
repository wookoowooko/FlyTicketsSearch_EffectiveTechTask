package io.wookoo.flyticketssearch.domain.repo

import io.wookoo.flyticketssearch.domain.models.UserFromModel
import kotlinx.coroutines.flow.Flow

interface IFlightDatabase {

    fun getUserInfo(): Flow<UserFromModel>

    suspend fun saveUserInfo(userFromModel: UserFromModel)
}
