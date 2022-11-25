package turnertech.lotto;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/** 
 * Represents a single draw of 6aus49. Note that the balls are stored in the order they
 * were drawn.
 * 
 * @author Luke Ian Turner
 * @since 1.0.0
*/
public class Draw {
    
    private final List<Integer> numbers;

    private final LocalDate drawDate;

    /**
     * The only constructor. A draw must be instantiated with all information as it is immutable.
     * 
     * @param numbers
     * @param drawDate The date the draw took place
     */
    public Draw(List<Integer> numbers, final LocalDate drawDate) {
        if(numbers == null || numbers.size() != 7) {
            throw new IllegalArgumentException("Incorrect number of balls passed to draw constructor.");
        }
        for(Integer number : numbers) {
            if(!Helper.isValidBall(number)) {
                throw new IllegalArgumentException("Illegal ball number provided to Draw constructor.");
            }
        }
        if(drawDate == null) {
            throw new IllegalArgumentException("drawDate may not be null.");
        }
        this.numbers = Collections.unmodifiableList(numbers);
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
        return numbers.get(6) == number;
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
