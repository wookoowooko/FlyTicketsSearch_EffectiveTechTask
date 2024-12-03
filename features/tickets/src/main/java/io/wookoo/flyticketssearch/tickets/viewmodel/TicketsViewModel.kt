package io.wookoo.flyticketssearch.tickets.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.domain.repo.IMasterRepository
import io.wookoo.flyticketssearch.domain.usecases.FormatPriceUseCase
import io.wookoo.flyticketssearch.tickets.ui.UiOffer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TicketsViewModel(
    private val masterRepository: IMasterRepository,
    private val formatPriceUseCase: FormatPriceUseCase
) : ViewModel() {

    private val _uiOffer = MutableStateFlow<List<UiOffer>>(emptyList())
    val uiOffer = _uiOffer.asStateFlow()

    init {
        loadOffers()
    }

    private fun loadOffers() {
        viewModelScope.launch {
            masterRepository.getAllOffers().collect { offers ->
                val uiOffers = offers.map { offerModel ->
                    val formattedPrice = formatPriceUseCase(offerModel.price.value)
                    offerModel.toUiOffer().copy(price = formattedPrice)
                }
                _uiOffer.value = uiOffers
            }
        }
    }

    private fun OfferModel.toUiOffer(): UiOffer {
        return UiOffer(
            id = id,
            title = title,
            price = price.value.toString(),
            town = town
        )
    }
}
