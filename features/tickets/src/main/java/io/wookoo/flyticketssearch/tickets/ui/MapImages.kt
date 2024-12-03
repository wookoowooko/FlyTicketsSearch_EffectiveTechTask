package io.wookoo.flyticketssearch.tickets.ui

import io.wookoo.flyticketssearch.tickets.R

object MapImages {

    fun mapImagesFromId(id: Int): Int {
        return when (id) {
            1 -> R.drawable.offer_1
            2 -> R.drawable.offer_2
            3 -> R.drawable.offer_3
            else -> R.drawable.offer_1
        }
    }
}