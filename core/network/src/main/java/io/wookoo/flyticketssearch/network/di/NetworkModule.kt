package io.wookoo.flyticketssearch.network.di

import io.wookoo.flyticketssearch.network.Client
import io.wookoo.flyticketssearch.network.IFlyApi
import io.wookoo.flyticketssearch.network.RetrofitConfig
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val networkModule = module {
    singleOf(::Client)
    singleOf(::RetrofitConfig)
    single<IFlyApi> {
        get<RetrofitConfig>().retrofit.create(IFlyApi::class.java)
    }
}
