package turnertech.lotto;

public class Helper {
    
    private Helper() {
        
    }

    public static boolean isValidBall(final int number) {
        return number > -1 && number < 50;
    }

}
