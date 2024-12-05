package io.wookoo.flyticketssearch.domain.models.info

data class HandLuggageModel(
    val hasHandLuggage: Boolean,
    val size: String? = null // Nullable because some tickets might not include a size.
)
