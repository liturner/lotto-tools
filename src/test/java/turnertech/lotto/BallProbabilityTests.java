package turnertech.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallProbabilityTests {

    @Test
    @DisplayName("Check .compareTo functionality")
	public void compareToTests() {
        BallProbability smaller = new BallProbability(1, 0.0);
        BallProbability larger = new BallProbability(1, 0.1);
        assertTrue(smaller.compareTo(larger) < 0);
        assertTrue(larger.compareTo(smaller) > 0);
        assertEquals(0, larger.compareTo(larger));
    }

    @Test
    @DisplayName("Check .equals functionality")
	public void equalsTests() {
        BallProbability smaller = new BallProbability(1, 0.0);
        BallProbability larger = new BallProbability(1, 0.1);
        assertEquals(smaller, smaller);
        assertEquals(larger, larger);
        assertNotEquals(smaller, larger);
        assertNotEquals(larger, smaller);
    }

    @Test
    @DisplayName("Check constructor exceptions")
	public void constructorExceptionsTests() {
        assertThrows(IllegalArgumentException.class, () -> {
            new BallProbability(1, 2.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new BallProbability(100, 0.5);
        });
    }
}
