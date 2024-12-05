package io.wookoo.flyticketssearch.domain.usecases

import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class CalculateFlightTimeUseCase {
    operator fun invoke(departure: String, arrival: String): String {
        val formatter = DateTimeFormatter.ISO_DATE_TIME
        val departureTime = LocalDateTime.parse(departure, formatter)
        val arrivalTime = LocalDateTime.parse(arrival, formatter)

        val duration: Duration = Duration.between(departureTime, arrivalTime)

        val hours = duration.toHours()
        val minutes = duration.toMinutes() % 60

        val formattedTime = if (minutes > 0) {
            val fractionalPart = minutes * 10 / 60 // Приводим к формату 0.5
            "$hours.$fractionalPart часа в пути"
        } else {
            "$hours часа в пути"
        }

        return formattedTime
    }
}
