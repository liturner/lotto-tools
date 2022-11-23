package turnertech.lotto;

/** Represents a single draw of 6aus49.
 * @author Luke Ian Turner
 * @since 1.0.0
*/
public class Draw {
    
    private final int[] numbers;

    private final int bonus;

    public Draw(final int number1, final int number2, final int number3, final int number4, final int number5, final int number6, final int bonus) {
        if(!Helper.isValidBall(number1) || !Helper.isValidBall(number2) || !Helper.isValidBall(number3) || !Helper.isValidBall(number4) || !Helper.isValidBall(number5) || !Helper.isValidBall(number6)) {
            throw new IllegalArgumentException("Illegal ball number provided to Draw constructor.");
        }
        if(!Helper.isValidBall(bonus)) {
            throw new IllegalArgumentException("Illegal bonus ball number provided to Draw constructor.");
        }

        this.numbers = new int[]{number1, number2, number3, number4, number5, number6};
        this.bonus = bonus;
    }

    /** Simple check function to query if a certain number is in the draw. Note that
     * any number can be passed to the check.
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

    public boolean hasBonus(final int number) {
        return number == bonus;
    }

}
