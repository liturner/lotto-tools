package turnertech.lotto.verification;

import java.util.List;

import turnertech.lotto.Draw;
import turnertech.lotto.analysis.AnalysisMethod;

/**
 * Various verification methods can verify various patterns. Not only
 * how often were the correct balls guessed, but how often were balls
 * to avoid correctly guessed.
 */
public interface VerificationMethod {
    
    /**
     * A verification must return a single verification percentage between 0 and 1.
     * 
     * @param analysisMethod The class to be instantiated and used for an analysis.
     * @param draws The historical draw data.
     * @return The various details of the verification 
     */
    public VerificationResult verify(Class<? extends AnalysisMethod> analysisMethod, List<Draw> draws);

}
