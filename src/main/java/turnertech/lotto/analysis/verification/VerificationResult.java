package turnertech.lotto.analysis.verification;

import turnertech.lotto.analysis.AnalysisResult;

/**
 * Various verification results. e.g. how often a single ball was predicted etc.
 */
public class VerificationResult {
    
    private AnalysisResult lastAnalysisResult;

    void setLastAnalysisResult(AnalysisResult lastAnalysisResult) {
        this.lastAnalysisResult = lastAnalysisResult;
    }

    /**
     * A bye product of the verification. The last analysis result is given here
     * and is quivelant to performing one analysis on the complete ball history.
     * 
     * @return The most current analysis result.
     */
    public AnalysisResult getLastAnalysisResult() {
        return lastAnalysisResult;
    }

}
