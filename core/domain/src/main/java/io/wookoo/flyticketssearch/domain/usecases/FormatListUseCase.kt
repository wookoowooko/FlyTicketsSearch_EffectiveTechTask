package io.wookoo.flyticketssearch.domain.usecases

class FormatListUseCase {

    operator fun invoke(list: List<String>): String {
        val builder = StringBuilder()
        list.forEachIndexed { index, item ->
            if (index == list.lastIndex) {
                builder.append(item)
            } else {
                builder.append("$item ")
            }
        }
        return builder.toString()
    }
}
