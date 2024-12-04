package io.wookoo.flyticketssearch.search.results.viewnodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchResultViewModel : ViewModel() {

    private val _textFrom = MutableStateFlow("")
    val textFrom = _textFrom.asStateFlow()

    private val _textWhere = MutableStateFlow("")
    val textWhere = _textWhere.asStateFlow()

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

}