package turnertech.lotto.analysis.methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import turnertech.lotto.BallProbability;
import turnertech.lotto.Draw;
import turnertech.lotto.Helper;
import turnertech.lotto.analysis.AnalysisDescription;
import turnertech.lotto.analysis.AnalysisMethod;
import turnertech.lotto.analysis.AnalysisResult;

/**
 * Assumes all balls are equal chance every time. Picks balls at true random
 */
@AnalysisDescription(name = "Assume Equal Chance", author = "Luke Ian Turner")
public class PureRandom implements AnalysisMethod {
    
    public AnalysisResult analyse(final List<Draw> draws) {
        ArrayList<BallProbability> ballProbabilities = new ArrayList<>(49);
        ArrayList<Integer> balls = new ArrayList<>(6);

        for(int number = 1; number <= 49; ++number) {
            BallProbability ballProbability = new BallProbability(number, Helper.SINGLE_BALL_CHANCE);
            ballProbabilities.add(ballProbability);
        }

        // Get the most likely balls
        Collections.sort(ballProbabilities);
        Collections.reverse(ballProbabilities);

        for(int ball = 0; ball < 6; ++ball) {
            balls.add(ball, new Random().nextInt(49 - 1 + 1) + 1);
        }

        return new AnalysisResult(this, ballProbabilities, balls);
    }

}
