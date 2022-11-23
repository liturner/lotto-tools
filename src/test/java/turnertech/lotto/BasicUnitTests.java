package turnertech.lotto;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.Test;

public class BasicUnitTests {

    @Test
	public void dummyTest() {
        assertFalse(Helper.isValidBall(-1));
        assertTrue(Helper.isValidBall(0));
    }
}
