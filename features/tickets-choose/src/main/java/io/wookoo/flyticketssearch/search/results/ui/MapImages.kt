package io.wookoo.flyticketssearch.search.results.ui

object MapImages {

    fun mapImagesFromId(id: Int): Int {
        return when (id) {
            1 -> io.wookoo.tickets.shared.R.drawable.special_orange_placeholder
            2 -> io.wookoo.tickets.shared.R.drawable.special_blue_placeholder
            3 -> io.wookoo.tickets.shared.R.drawable.special_white_placeholder
            else -> io.wookoo.tickets.shared.R.drawable.special_white_placeholder
        }
    }
}
