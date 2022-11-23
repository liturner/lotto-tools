package turnertech.lotto;

import java.util.Collections;
import java.util.List;

public class AnalysisResult {
    
    private final List<BallProbability> probabilities;

    private final List<Integer> balls;

    public AnalysisResult(final List<BallProbability> probabilities, final List<Integer> balls) {
        this.probabilities = Collections.unmodifiableList(probabilities);
        this.balls = Collections.unmodifiableList(balls);
    }

    public Double chanceOf(final Integer number) {
        for (BallProbability ballProbability : probabilities) {
            if(ballProbability.getNumber().equals(number)) {
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
        for (BallProbability ballProbability : probabilities) {
            System.out.printf(" | %2s : %.4f", ballProbability.getNumber(), ballProbability.getProbability());
            if(ballProbability.getNumber() % 10 == 0) {
                System.out.print(" |\n");
            }
        }
        System.out.print("\n ## Recomended Balls\n");
        System.out.println(balls);
    }

}
