package io.wookoo.flyticketssearch.data.database.di

import io.wookoo.flyticketssearch.data.database.database.FlightDatabase
import io.wookoo.flyticketssearch.data.database.database.flightDatabase
import org.koin.dsl.module

val databaseModule = module {
    single<FlightDatabase> { FlightDatabase(get()) }
    single { flightDatabase(get()) }
}
