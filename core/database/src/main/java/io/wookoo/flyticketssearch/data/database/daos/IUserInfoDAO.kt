package io.wookoo.flyticketssearch.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.wookoo.flyticketssearch.data.database.dbos.UserFromEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IUserInfoDAO {

    @Query("SELECT * FROM user ORDER BY id DESC LIMIT 1")
    fun getUserInfo(): Flow<UserFromEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUserInfo(userFromEntity: UserFromEntity)

}