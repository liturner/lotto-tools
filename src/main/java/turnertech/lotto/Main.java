package turnertech.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import turnertech.lotto.analysis.AnalysisMethod;
import turnertech.lotto.analysis.methods.BasicAnalysis;
import turnertech.lotto.analysis.verification.Verification;
import turnertech.lotto.analysis.verification.VerificationResult;

/**
 * Currently the only executable method for this application. Used to analyse
 * all balls with all methods.
 */
public class Main {

    /**
     * Basic no gui analysis using all methods and printing results using the loggers.
     * 
     * @param args System provided arguments
     */
    public static void main(String[] args) {
        List<Draw> draws = Helper.loadDraws(Main.class.getResource("/lotto.txt"));

        List<Class<? extends AnalysisMethod>> analysisMethods = new ArrayList<>();
        analysisMethods.add(BasicAnalysis.class);

        for (Class<? extends AnalysisMethod> analysisMethod : analysisMethods) {
            VerificationResult verificationResult = new Verification(analysisMethod, draws).verify();
            Logging.LOGGER.log(Level.INFO, () -> verificationResult.getLastAnalysisResult().toString());
        }
    }
}