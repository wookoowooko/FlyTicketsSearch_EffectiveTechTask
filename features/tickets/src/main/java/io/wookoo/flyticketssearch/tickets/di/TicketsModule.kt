package io.wookoo.flyticketssearch.tickets.di

import io.wookoo.flyticketssearch.tickets.modal.ModalBottomSheetViewModel
import io.wookoo.flyticketssearch.tickets.viewmodel.TicketsViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val ticketsModule = module {
    viewModelOf(::TicketsViewModel)
    viewModelOf(::ModalBottomSheetViewModel)
}
