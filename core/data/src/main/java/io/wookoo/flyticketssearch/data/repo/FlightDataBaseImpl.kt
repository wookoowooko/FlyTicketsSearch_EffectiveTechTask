package io.wookoo.flyticketssearch.data.repo

import io.wookoo.flyticketssearch.data.database.database.FlightDatabase
import io.wookoo.flyticketssearch.data.mappers.toUserFromEntity
import io.wookoo.flyticketssearch.data.mappers.toUserFromModel
import io.wookoo.flyticketssearch.domain.models.UserFromModel
import io.wookoo.flyticketssearch.domain.repo.IFlightDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

class FlightDataBaseImpl(
    flightDatabase: FlightDatabase
) : IFlightDatabase {

    private val userFromDao = flightDatabase.userFromDao

    override fun getUserInfo(): Flow<UserFromModel> {
        return userFromDao.getUserInfo().mapNotNull { userFromEntity ->
            userFromEntity?.toUserFromModel()
        }
    }

    override suspend fun saveUserInfo(userFromModel: UserFromModel) {
        userFromDao.saveUserInfo(userFromModel.toUserFromEntity())
    }
}
