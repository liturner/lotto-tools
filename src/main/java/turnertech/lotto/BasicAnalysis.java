package turnertech.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This Analysis uses a sample based on the last time a particular number appeared. Using basic probability multiplcation we then accumulate the chance of rolling any other number for untill the last draw. This method shows how the chance of drawing a number which has not been drawn in several draws, slowly increases. Note, that the probabilities returned here are not normalised and do not represent percentage chances.
 */
public class BasicAnalysis {
    
    // Chance of any one ball occuring in any one draw.
    private static final Double SINGLE_BALL_CHANCE = 6.0 / 49.0;

    // Chance of any one other ball occuring in any one draw.
    private static final Double OTHER_BALL_CHANCE = (49.0 - 6.0) / 49.0;

    public static AnalysisResult analyse(final List<Draw> draws) {
        ArrayList<BallProbability> ballProbabilities = new ArrayList<BallProbability>(49);
        ArrayList<Integer> balls = new ArrayList<Integer>(6);

        for(int number = 1; number <= 49; ++number) {
            BallProbability ballProbability = new BallProbability(number, chanceOf(draws, number));
            ballProbabilities.add(ballProbability);
        }


        // Get the most likely balls
        Collections.sort(ballProbabilities);
        Collections.reverse(ballProbabilities);
        for(int ball = 0; ball < 6; ++ball) {
            balls.add(ball, ballProbabilities.get(ball).getNumber());
        }

        return new AnalysisResult(ballProbabilities, balls);
    }

    private static Double chanceOf(final List<Draw> draws, final int number) {        
        Double cumulativeOtherBallChance = OTHER_BALL_CHANCE;

        for(Draw draw :draws) {
            if(draw.hasNumber(number)) {
                cumulativeOtherBallChance = OTHER_BALL_CHANCE;
            } else {
                cumulativeOtherBallChance = cumulativeOtherBallChance * OTHER_BALL_CHANCE;
            }
        }

        return 1 - cumulativeOtherBallChance;
    }

}
