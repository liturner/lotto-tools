package turnertech.lotto;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

public class AnalysisResult {
    
    private final List<BallProbability> probabilities;

    private final List<Integer> balls;

    public AnalysisResult(final List<BallProbability> probabilities, final List<Integer> balls) {
        this.probabilities = Collections.unmodifiableList(probabilities);
        this.balls = Collections.unmodifiableList(balls);
    }

    public Double chanceOf(final int number) {
        for (BallProbability ballProbability : probabilities) {
            if(ballProbability.getNumber() == number) {
                return ballProbability.getProbability();
            }
        }
        return 0.0;
    }

    public List<Integer> recomendedBalls() {
        return balls;
    }

    @Override
    public String toString() {
        return balls.toString();
    }

    public void print() {
        Logging.LOGGER.log(Level.INFO, "Print using a good string format and lots of .toString");
    }

}
