package io.wookoo.flyticketssearch.domain.usecases

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class FormatTimeUseCase {
    operator fun invoke(string: String): String {
        val inputFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
        val outputFormatter = DateTimeFormatter.ofPattern("HH:mm")

        val dateTime = LocalDateTime.parse(string, inputFormatter)
        return dateTime.format(outputFormatter)
    }
}
