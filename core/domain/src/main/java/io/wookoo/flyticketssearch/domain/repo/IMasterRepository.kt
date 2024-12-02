package io.wookoo.flyticketssearch.domain.repo

import io.wookoo.flyticketssearch.domain.models.OfferModel
import kotlinx.coroutines.flow.Flow

interface IMasterRepository {
    fun getAllOffers(): Flow<List<OfferModel>>
}