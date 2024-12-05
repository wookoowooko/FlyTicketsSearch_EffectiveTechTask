import io.wookoo.flyticketssearch.domain.usecases.CalculateFlightTimeUseCase
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CalculateFlightTimeUseCaseTest {
    private lateinit var calculateFlightTimeUseCase: CalculateFlightTimeUseCase


    @Before
    fun setUp() {
         calculateFlightTimeUseCase = CalculateFlightTimeUseCase()
    }

    @Test
    fun `should calculate flight time in hours correctly`() {
        val departure = "2024-02-23T15:00:00"
        val arrival = "2024-02-23T18:30:00"

        val result = calculateFlightTimeUseCase(departure, arrival)
        assertEquals("3.5 часа в пути", result)
    }

    @Test
    fun `should calculate flight time with only hours correctly`() {
        val departure = "2024-02-23T15:00:00"
        val arrival = "2024-02-23T18:00:00"

        val result = calculateFlightTimeUseCase(departure, arrival)
        assertEquals("3 часа в пути", result)
    }

    @Test
    fun `should calculate flight time when departure is from the another day`() {
        val departure = "2024-02-22T15:00:00"
        val arrival = "2024-02-23T18:30:00"

        val result = calculateFlightTimeUseCase(departure, arrival)
        assertEquals("27.5 часа в пути", result)
    }

    @Test
    fun `should handle zero minute difference correctly`() {
        val departure = "2024-02-23T15:00:00"
        val arrival = "2024-02-23T15:00:00"

        val result = calculateFlightTimeUseCase(departure, arrival)
        assertEquals("0 часа в пути", result)
    }

}