package io.wookoo.flyticketssearch.domain.di

import io.wookoo.flyticketssearch.domain.usecases.CalculateFlightTimeUseCase
import io.wookoo.flyticketssearch.domain.usecases.FormatDateUseCase
import io.wookoo.flyticketssearch.domain.usecases.FormatListUseCase
import io.wookoo.flyticketssearch.domain.usecases.FormatPriceUseCase
import io.wookoo.flyticketssearch.domain.usecases.FormatTimeUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::FormatPriceUseCase)
    singleOf(::FormatDateUseCase)
    singleOf(::FormatListUseCase)
    singleOf(::FormatTimeUseCase)
    singleOf(::CalculateFlightTimeUseCase)
}
