package io.wookoo.flyticketssearch.search.results.viewnodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.wookoo.flyticketssearch.domain.repo.IMasterRepository
import io.wookoo.flyticketssearch.domain.usecases.FormatDateUseCase
import io.wookoo.flyticketssearch.domain.usecases.FormatListUseCase
import io.wookoo.flyticketssearch.domain.usecases.FormatPriceUseCase
import io.wookoo.flyticketssearch.search.results.ui.UiTicketOffer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date

class SearchResultViewModel(
    private val formatDateUseCase: FormatDateUseCase,
    private val masterRepository: IMasterRepository,
    private val formatPriceUseCase: FormatPriceUseCase,
    private val formatListUseCase: FormatListUseCase
) : ViewModel() {

    private val _uiTicketsOffers = MutableStateFlow<List<UiTicketOffer>>(emptyList())
    val uiTicketsOffers = _uiTicketsOffers.asStateFlow()

    init {
        fetchTicketsOffers()
    }

    private fun fetchTicketsOffers() {
        viewModelScope.launch {
            masterRepository.getAllTicketOffers().collect { ticketsOffers ->
                val uiTicketOffers = ticketsOffers.map { offerModel ->
                    UiTicketOffer(
                        id = offerModel.id,
                        title = offerModel.title,
                        price = formatPriceUseCase(offerModel.price.value),
                        timeRange = formatListUseCase(offerModel.timeRange)
                    )
                }
                _uiTicketsOffers.value = uiTicketOffers
            }
        }
    }

    private val today = Date()

    private val _textFrom = MutableStateFlow("")
    val textFrom = _textFrom.asStateFlow()

    private val _textWhere = MutableStateFlow("")
    val textWhere = _textWhere.asStateFlow()

    private val _dateDepartureOutbound = MutableStateFlow(formatDateUseCase.execute(today))
    val dateDepartureOutbound = _dateDepartureOutbound.asStateFlow()

    private val _dateReturn = MutableStateFlow("")
    val dateReturn = _dateReturn.asStateFlow()

    fun updateTextFrom(text: String) {
        _textFrom.value = text
    }

    fun updateTextWhere(text: String) {
        _textWhere.value = text
    }

    fun clearTextWhere() {
        _textWhere.value = ""
    }

    fun changeValues() {
        val from = _textFrom.value
        val where = _textWhere.value
        if (from != where) {
            _textFrom.value = where
            _textWhere.value = from
        }
    }

    fun formatDateOutbound(date: Date) {
        _dateDepartureOutbound.value = formatDateUseCase.execute(date)
    }

    fun formatDateReturn(date: Date) {
        _dateReturn.value = formatDateUseCase.execute(date)
    }
}
