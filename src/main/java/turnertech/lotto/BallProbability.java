package turnertech.lotto;

/** Represents the pairing of a ball, and its probability.
 * 
 * First probability is compared, then if equal the ball number. This is to ensure that
 * the compare to and equals contract are compatible.
 * 
 * This class is intended to be immutable.
 * 
 * This class does not require probability to be normalized between 0 and 1.
 * 
 * @author Luke Ian Turner
 * @since 1.0.0
 */
public class BallProbability implements Comparable<BallProbability> {

    private final int number;

    private final double probability;
    
    public BallProbability(final int number, final double probability) {
        this.number = number;
        this.probability = probability;
    }

    /** The natural ordering is based on both the probability and the ball number,
     * with the probability being the first parameter to be checked.
     * @author Luke Ian Turner
     * @since 1.0.0
     */
    @Override
    public int compareTo(BallProbability other) {
        double comparison = this.probability - other.probability;
        if(comparison == 0.0) {
            return this.number - other.number;
        } else if (comparison > 0.0) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object other) {
        if(!(other instanceof BallProbability)) {
            return false;
        }
        return this.number == ((BallProbability)other).number && this.probability == ((BallProbability)other).probability;
    }

    /** Getter for the ball number
     * @author Luke Ian Turner
     * @since 1.0.0
     * @return The number of the ball
     */
    public int getNumber() {
        return this.number;
    }

    /** Getter for the ball probability
     * @author Luke Ian Turner
     * @since 1.0.0
     * @return The probability of the ball being drawn
     */
    public double getProbability() {
        return this.probability;
    }

}
