package io.wookoo.flyticketssearch.network.network.di

import io.wookoo.flyticketssearch.network.Client
import io.wookoo.flyticketssearch.network.IOffersApi
import io.wookoo.flyticketssearch.network.RetrofitConfig
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    singleOf(::Client)
    singleOf(::RetrofitConfig)
    single<IOffersApi> {
        get<RetrofitConfig>().retrofit.create(IOffersApi::class.java)
    }
}
