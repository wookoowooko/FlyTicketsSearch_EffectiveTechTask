package io.wookoo.flyticketssearch.tickets.viewmodel

import android.content.ContentValues.TAG
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.wookoo.flyticketssearch.domain.models.OfferModel
import io.wookoo.flyticketssearch.domain.repo.IMasterRepository
import io.wookoo.flyticketssearch.logger.MyLogger.logger
import io.wookoo.flyticketssearch.tickets.screen.UiOffer
import kotlinx.coroutines.launch


class TicketsViewModel(
    private val masterRepository: IMasterRepository,
) : ViewModel() {

    private val _uiOffer = MutableLiveData<List<UiOffer>>()
    val uiOffer: LiveData<List<UiOffer>> get() = _uiOffer

    init {
        logger.info(TAG, "initialized")
    }

    fun loadOffers() {
        logger.info(TAG, "loadOffers")
        viewModelScope.launch {
            logger.info(TAG, "viewModelScope.launch")
            masterRepository.getAllOffers().collect { offers ->
                logger.info(TAG, "collect")
                val uiOffers = offers.map { it.toUiOffer() }
                logger.info(TAG, "map")
                _uiOffer.value = uiOffers
            }
        }
    }

    private fun OfferModel.toUiOffer(): UiOffer {
        return UiOffer(
            id = id,
            title = title,
            price = price.value,
            town = town
        )
    }
}
