package turnertech.lotto;

import java.time.LocalDate;

/** 
 * Represents a single draw of 6aus49. Note that the balls are stored in the order they
 * were drawn.
 * 
 * @author Luke Ian Turner
 * @since 1.0.0
*/
public class Draw {
    
    private final int[] numbers;

    private final int bonus;

    private final LocalDate drawDate;

    /**
     * The only constructor. A draw must be instantiated with all information as it is immutable.
     * 
     * @param number1 The first drawn ball
     * @param number2 The second drawn ball
     * @param number3 The third drawn ball
     * @param number4 The fourth drawn ball
     * @param number5 The fifth drawn ball
     * @param number6 The sixth drawn ball
     * @param bonus The Bonus Ball
     * @param drawDate The date the draw took place
     */
    public Draw(final int number1, final int number2, final int number3, final int number4, final int number5, final int number6, final int bonus, final LocalDate drawDate) {
        if(!Helper.isValidBall(number1) || !Helper.isValidBall(number2) || !Helper.isValidBall(number3) || !Helper.isValidBall(number4) || !Helper.isValidBall(number5) || !Helper.isValidBall(number6)) {
            throw new IllegalArgumentException("Illegal ball number provided to Draw constructor.");
        }
        if(!Helper.isValidBall(bonus)) {
            throw new IllegalArgumentException("Illegal bonus ball number provided to Draw constructor.");
        }
        if(drawDate == null) {
            throw new IllegalArgumentException("drawDate may not be null.");
        }

        this.numbers = new int[]{number1, number2, number3, number4, number5, number6};
        this.bonus = bonus;
        this.drawDate = drawDate;
    }

    /** 
     * Simple check function to query if a certain number is in the draw. Note that
     * any number can be passed to the check.
     * 
     * @author Luke Ian Turner
     * @since 1.0.0
     * @param number Integer number to check if it is contained in the draw
     * @return True or False
     */
    public boolean hasNumber(final int number) {
        for (int n : numbers) {
            if(n == number) {
                return true;
            }
        }
        return false;
    }

    /** 
     * Simple check function to query if a certain number is the bonus ball. Note that
     * any number can be passed to the check.
     * 
     * @author Luke Ian Turner
     * @since 1.0.0
     * @param number Integer number to check if it is contained in the draw
     * @return True or False
     */
    public boolean hasBonus(final int number) {
        return number == bonus;
    }

    /**
     * Getter for the date of the draw.
     * 
     * @author Luke Ian Turner
     * @since 1.0.0
     * @return The date of the draw.
     */
    public LocalDate getDrawDate() {
        return drawDate;
    }

}
