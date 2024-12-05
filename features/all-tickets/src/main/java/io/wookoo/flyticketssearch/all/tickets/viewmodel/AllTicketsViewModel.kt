package io.wookoo.flyticketssearch.all.tickets.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.wookoo.flyticketssearch.all.tickets.ui.UiTicket
import io.wookoo.flyticketssearch.domain.repo.IMasterRepository
import io.wookoo.flyticketssearch.domain.usecases.FormatPriceUseCase
import io.wookoo.flyticketssearch.logger.MyLogger.logger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AllTicketsViewModel(
    private val masterRepository: IMasterRepository,
    private val formatPriceUseCase: FormatPriceUseCase
):ViewModel() {

    private val _uiTickets = MutableStateFlow<List<UiTicket>>(emptyList())
    val uiTickets = _uiTickets.asStateFlow()

    init {
        getAllTickets()
    }

    private fun getAllTickets(){
        viewModelScope.launch {
            masterRepository.getTickets().collect{ tickets ->
                val uiTickets = tickets.map { ticketModel ->
                    UiTicket(
                        id = ticketModel.id.toString(),
                        badge = ticketModel.badge,
                        price = formatPriceUseCase(ticketModel.price.value),
                        departureTime = ticketModel.departure.date,
                        departureAirport = ticketModel.departure.airport,
                        arrivalTime = ticketModel.arrival.date,
                        arrivalAirport = ticketModel.arrival.airport,
                        timeToFly = "12",
                        hasTransfer = ticketModel.hasTransfer,
                    )
                }
                _uiTickets.value = uiTickets
            }
        }
    }
}