package io.wookoo.flyticketssearch.data.di

import io.wookoo.flyticketssearch.data.repo.MasterRepositoryImpl
import io.wookoo.flyticketssearch.data.repo.NetworkApiImpl
import io.wookoo.flyticketssearch.domain.repo.IMasterRepository
import io.wookoo.flyticketssearch.domain.repo.INetworkApi
import io.wookoo.flyticketssearch.network.network.di.networkModule
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    singleOf(::NetworkApiImpl) { bind<INetworkApi>() }
    singleOf(::MasterRepositoryImpl) { bind<IMasterRepository>() }
} + io.wookoo.flyticketssearch.network.network.di.networkModule
