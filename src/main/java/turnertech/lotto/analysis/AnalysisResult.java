package turnertech.lotto.analysis;

import java.util.Collections;
import java.util.List;

import turnertech.lotto.BallProbability;
import turnertech.lotto.analysis.verification.VerificationResult;

/**
 * An analysis result returns various conclusions from an {@link AnalysisMethod}.
 * Ideally all aspects of this instance should be populated, although this is not
 * a requirement. Any user of this class must assume that any data may be not 
 * present (i.e. null).
 * 
 * Not to be confused with {@link VerificationResult}. The verification result 
 * checks how often the {@link AnalysisResult} was correct.
 */
public class AnalysisResult {
    
    private final AnalysisDescription analysisDescription;

    private final List<BallProbability> probabilities;

    private final List<Integer> balls;

    /**
     * This will be reworked
     * 
     * @param analysisMethod Method description containing metadata such as author
     * @param probabilities List of probabilities for all balls
     * @param balls List of balls recomended to be drawn
     */
    public AnalysisResult(AnalysisMethod analysisMethod, final List<BallProbability> probabilities, final List<Integer> balls) {
        this.analysisDescription = analysisMethod.getClass().getAnnotation(AnalysisDescription.class);
        if(analysisDescription == null) {
            throw new IllegalArgumentException("analysisMethod must implement the AnalysisDescription annotation");
        }

        this.probabilities = Collections.unmodifiableList(probabilities);
        this.balls = Collections.unmodifiableList(balls);
    }

    /**
     * Returns the probability estimated for a particular ball. Note that this value
     * is not guarenteed to be normalized between 0 and 1.
     * 
     * @param number The number of the ball for which a probability should be returned.
     * @return The probability of the ball. Invalid balls will return 0
     */
    public Double chanceOf(final int number) {
        for (BallProbability ballProbability : probabilities) {
            if(ballProbability.getNumber() == number) {
                return ballProbability.getProbability();
            }
        }
        return 0.0;
    }

    /**
     * The apprently impossible to predict prediction.
     * 
     * @return A list of predicted balls
     */
    public List<Integer> recomendedBalls() {
        return balls;
    }

    /**
     * Gets the name from the {@link AnalysisDescription} interface
     * of the analysis method.
     * 
     * @return Name, as passed in by the {@link AnalysisDescription}
     */
    public String getAnalysisName() {
        return analysisDescription.name();
    }

    /**
     * Gets the author from the {@link AnalysisDescription} interface
     * of the analysis method.
     * 
     * @return Author's name
     */
    public String getAnalysisAuthor() {
        return analysisDescription.author();
    }

    @Override
    public String toString() {
        return String.format("%n# Method: %s%n%n## Author: %s%n%n- Predicted Balls: %s%n- Ball Probabilities: %s%n", this.getAnalysisName(), this.getAnalysisAuthor(), recomendedBalls().toString(), probabilities);
    }

}
