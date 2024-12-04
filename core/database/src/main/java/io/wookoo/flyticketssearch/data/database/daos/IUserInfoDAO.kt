package io.wookoo.flyticketssearch.data.database.daos

import androidx.room.Dao
import androidx.room.Query
import io.wookoo.flyticketssearch.data.database.dbos.UserFromEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IUserInfoDAO {

    @Query("SELECT * FROM user")
    fun getUserInfo(): Flow<UserFromEntity>

    @Query("INSERT INTO user (last_user_input) VALUES (:userInput)")
    suspend fun insertUserInfo(userInput: String)

}