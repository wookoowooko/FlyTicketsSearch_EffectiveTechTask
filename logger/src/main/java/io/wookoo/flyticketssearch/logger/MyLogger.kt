package io.wookoo.flyticketssearch.logger

object MyLogger {

    val logger = this

    private object AnsiColors {
        const val GREEN = "✅"
        const val RED = "❌"
        const val BLUE = "🔵"
        const val YELLOW = "\uD83D\uDFE1"
    }

    private const val DEFAULT_TAG = "MyLogger"

    private fun log(tag: String, message: String, level: String) {
        val formattedMessage = "$tag: $message"
        when (level) {
            "INFO" -> println("${AnsiColors.BLUE} INFO: $formattedMessage")
            "SUCCESS" -> println("${AnsiColors.GREEN} SUCCESS: $formattedMessage")
            "ERROR" -> println("${AnsiColors.RED} ERROR: $formattedMessage")
            "TASK" -> println("${AnsiColors.YELLOW} TASK: $formattedMessage")
        }
    }

    fun info(tag: String = DEFAULT_TAG, message: String) {
        log(tag, message, "INFO")
    }

    fun task(tag: String = DEFAULT_TAG, message: String) {
        log(tag, message, "TASK")
    }

    fun success(tag: String = DEFAULT_TAG, message: String) {
        log(tag, message, "SUCCESS")
    }

    fun error(tag: String = DEFAULT_TAG, message: String) {
        log(tag, message, "ERROR")
    }
}
