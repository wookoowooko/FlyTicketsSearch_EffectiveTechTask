package io.wookoo.flyticketssearch.search.results.di

import io.wookoo.flyticketssearch.all.tickets.di.allTicketsModule
import io.wookoo.flyticketssearch.search.results.viewnodel.SearchResultViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val searchResultModule = module {
    viewModelOf(::SearchResultViewModel)
} + allTicketsModule
