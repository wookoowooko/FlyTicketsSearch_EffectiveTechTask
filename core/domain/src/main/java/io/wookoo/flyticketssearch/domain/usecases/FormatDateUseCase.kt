package io.wookoo.flyticketssearch.domain.usecases

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FormatDateUseCase {

    fun execute(date: Date): String {
        // Форматируем дату в нужный формат: "24 фев"
        val dateFormat = SimpleDateFormat("d MMM", Locale.getDefault())
        val formattedDate = dateFormat.format(date)

        // Получаем день недели (например, сб)
        val dayOfWeek = SimpleDateFormat("E", Locale.getDefault()).format(date)
            .lowercase(Locale.getDefault())

        val finalDate = "$formattedDate, $dayOfWeek".replace(".", "")

        return finalDate
    }
}
