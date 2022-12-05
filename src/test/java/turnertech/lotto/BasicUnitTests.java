package turnertech.lotto;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class BasicUnitTests {

    @Test
	public void dummyTest() {
        assertFalse(Helper.isValidBall(-1));
        assertFalse(Helper.isValidBall(0));
    }
}
