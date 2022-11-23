package turnertech.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BallProbabilityTests {

    @Test
	public void compareToTests() {
        BallProbability smaller = new BallProbability(1, 0.0);
        BallProbability larger = new BallProbability(1, 0.1);
        assertTrue(smaller.compareTo(larger) < 0);
        assertTrue(larger.compareTo(smaller) > 0);
        assertEquals(0, larger.compareTo(larger));
    }

    @Test
	public void equalsTests() {
        BallProbability smaller = new BallProbability(1, 0.0);
        BallProbability larger = new BallProbability(1, 0.1);
        assertEquals(smaller, smaller);
        assertEquals(larger, larger);
        assertNotEquals(smaller, larger);
        assertNotEquals(larger, smaller);
    }
}
