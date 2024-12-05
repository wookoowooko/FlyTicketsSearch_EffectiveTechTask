package io.wookoo.flyticketssearch.data.di

import io.wookoo.flyticketssearch.data.database.di.databaseModule
import io.wookoo.flyticketssearch.data.repo.FlightDataBaseImpl
import io.wookoo.flyticketssearch.data.repo.MasterRepositoryImpl
import io.wookoo.flyticketssearch.data.repo.NetworkApiImpl
import io.wookoo.flyticketssearch.domain.di.dispatcherModule
import io.wookoo.flyticketssearch.domain.di.domainModule
import io.wookoo.flyticketssearch.domain.repo.IFlightDatabase
import io.wookoo.flyticketssearch.domain.repo.IMasterRepository
import io.wookoo.flyticketssearch.domain.repo.INetworkApi
import io.wookoo.flyticketssearch.network.di.networkModule
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single<INetworkApi> { NetworkApiImpl(get(), get(named("IO"))) }
    singleOf(::MasterRepositoryImpl) { bind<IMasterRepository>() }
    singleOf(::FlightDataBaseImpl) { bind<IFlightDatabase>() }
} + networkModule + domainModule + databaseModule + dispatcherModule
