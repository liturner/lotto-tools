package turnertech.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelperTests {

    @Test
	public void dummyTest() {
        assertEquals(Helper.SINGLE_BALL_CHANCE, 6.0 / 49.0);
    }

    @Test
    @DisplayName("Check probability validation")
	public void isValidProbabilityTest() {
        assertTrue(Helper.isValidProbability(0));
        assertTrue(Helper.isValidProbability(0.0));
        assertTrue(Helper.isValidProbability(0.5));
        assertTrue(Helper.isValidProbability(0.999999999999999999));
        assertTrue(Helper.isValidProbability(1.0));
        assertTrue(Helper.isValidProbability(1));
        assertFalse(Helper.isValidProbability(1.00000000000001));
        assertFalse(Helper.isValidProbability(-0.000000000000000000000000000000001));
        assertFalse(Helper.isValidProbability(Double.MAX_VALUE));
    }

}
