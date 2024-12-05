package io.wookoo.flyticketssearch.all.tickets.di

import io.wookoo.flyticketssearch.all.tickets.viewmodel.AllTicketsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val allTicketsModule = module {
    viewModelOf(::AllTicketsViewModel)
}
