package io.wookoo.flyticketssearch.domain.usecases

class FormatPriceUseCase {
    operator fun invoke(price: Int): String {
        return "%,d ₽".format(price).replace(',', ' ')
    }
}