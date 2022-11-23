package turnertech.lotto;

public class Helper {
    
    private Helper() {
        
    }

    // Chance of any one ball occuring in any one draw.
    public static final Double SINGLE_BALL_CHANCE = 6.0 / 49.0;

    public static boolean isValidBall(final int number) {
        return number > -1 && number < 50;
    }

}
