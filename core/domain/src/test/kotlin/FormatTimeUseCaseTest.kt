import io.wookoo.flyticketssearch.domain.usecases.FormatTimeUseCase
import org.junit.Before
import org.junit.Test

class FormatTimeUseCaseTest {


    private lateinit var formatTimeUseCase: FormatTimeUseCase

    @Before
       fun setUp() {
           formatTimeUseCase  = FormatTimeUseCase()
    }

    @Test
    fun mustReturnTimeString() {
        val input = "2024-02-23T07:10:00"
        val expectedOutput = "07:10"
        val output = formatTimeUseCase(input)
        assert(output == expectedOutput)
    }

}