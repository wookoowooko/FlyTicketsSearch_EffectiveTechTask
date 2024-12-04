import io.wookoo.flyticketssearch.domain.usecases.FormatListUseCase
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class FormatListUseCaseTest {

    private lateinit var formatListUseCase: FormatListUseCase

    @Before
    fun setUp() {
        formatListUseCase = FormatListUseCase()
    }


    @Test
    fun `listReturnStringWithSpaces returns items separated by space`() {

        val list = listOf("07:10", "07:22", "10:30")
        val expectedResult = "07:10 07:22 10:30"
        val result = formatListUseCase.execute(list)

        assertEquals(expectedResult, result)
    }
}