package turnertech.lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HelperTests {

    @Test
	public void dummyTest() {
        assertEquals(Helper.SINGLE_BALL_CHANCE, 6.0 / 49.0);
    }
}
