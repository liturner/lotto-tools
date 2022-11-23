package turnertech.lotto;

public class BallProbability implements Comparable<BallProbability> {

    private final Integer number;

    private final Double probability;
    
    public BallProbability(final Integer number, final Double probability) {
        this.number = number;
        this.probability = probability;
    }

    @Override
    public int compareTo(BallProbability other) {
        Double comparison = this.probability - other.probability;
        if(comparison == 0.0) {
            return 0;
        } else if (comparison > 0.0) {
            return 1;
        } else {
            return -1;
        }
    }

    public Integer getNumber() {
        return this.number;
    }

    public Double getProbability() {
        return this.probability;
    }

}
