package turnertech.lotto.analysis.verification;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import turnertech.lotto.Draw;
import turnertech.lotto.Logging;
import turnertech.lotto.analysis.AnalysisMethod;
import turnertech.lotto.analysis.AnalysisResult;

/**
 * Simulates a method over the life of the entire history of draws
 * and provides a result.
 * 
 * Verification can verify various patterns. Not only
 * how often were the correct balls guessed, but how often were balls
 * to avoid correctly guessed.
 */
public class Verification {
    
    private final Class<? extends AnalysisMethod> analysisMethod;

    private final List<Draw> draws;

    /**
     * Constructor
     * 
     * @param analysisMethod The class to be instantiated and used for an analysis.
     * @param draws The historical draw data.
     */
    public Verification(final Class<? extends AnalysisMethod> analysisMethod, final List<Draw> draws) {
        this.analysisMethod = analysisMethod;
        this.draws = draws;
    }

    /**
     * A verification must return a single verification result, containing all analysis
     * information.
     * 
     * @return The various details of the verification 
     */
    public VerificationResult verify() {
        AnalysisMethod instantiatedAnalysisMethod = null;
        AnalysisResult analysisResult = null;
        int lastXdraws = 100;
        VerificationResult verificationResult = new VerificationResult(lastXdraws);

        String csv = "";

        while(lastXdraws > 0) {
            List<Draw> historicalSet = draws.subList(0, draws.size() - lastXdraws);
            Draw actuallDraw = draws.get(draws.size() - lastXdraws);
            
            try {
                instantiatedAnalysisMethod = analysisMethod.getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                    | NoSuchMethodException | SecurityException e) {
                Logging.LOGGER.log(Level.SEVERE, "Failed to instantiate the AnalysisMethod.", e);
                return null;
            }   
            
            analysisResult = instantiatedAnalysisMethod.analyse(historicalSet);

            for(Integer number : actuallDraw.getNumbers()) {
                csv += analysisResult.chanceOf(number).toString() + "\n";
            }
            
            
            List<Integer> hits = new ArrayList<>(6);
            for (Integer number : analysisResult.recomendedBalls()) {
                if(actuallDraw.hasNumber(number)) {
                    Logging.LOGGER.log(Level.INFO, String.format("Ball guessed correctly with chance: %.3f", analysisResult.chanceOf(number)));
                    hits.add(number);
                }
            }
            
            verificationResult.addAnalysisResult(analysisResult, hits);
            --lastXdraws;
        }
        Logging.LOGGER.log(Level.INFO, csv);       

        return verificationResult;
    }

}
