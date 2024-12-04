package io.wookoo.flyticketssearch.search.results.viewnodel

import androidx.lifecycle.ViewModel
import io.wookoo.flyticketssearch.domain.usecases.FormatDateUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Date

class SearchResultViewModel(
    private val formatDateUseCase: FormatDateUseCase
) : ViewModel() {

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
