package io.wookoo.flyticketssearch.data.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.wookoo.flyticketssearch.data.database.daos.IUserInfoDAO
import io.wookoo.flyticketssearch.data.database.dbos.UserFromEntity

class FlightDatabase internal constructor(private val database: FlightDatabaseRoom) {
    val userFromDao: IUserInfoDAO
        get() = database.userFromDao()
}


@Database(entities = [UserFromEntity::class], version = 1, exportSchema = true)
abstract class FlightDatabaseRoom : RoomDatabase() {
    abstract fun userFromDao(): IUserInfoDAO
}

fun flightDatabase(applicationContext: Context): FlightDatabase {
    val flightDatabase =
        Room.databaseBuilder(
            checkNotNull(applicationContext.applicationContext),
            FlightDatabaseRoom::class.java,
            "flight_database"
        ).addMigrations()
            .build()
    return FlightDatabase(flightDatabase)
}
