package turnertech.lotto;

import java.util.List;
import java.util.logging.Level;

import turnertech.lotto.analysis.AnalysisResult;
import turnertech.lotto.analysis.methods.BasicAnalysis;

public class Main {

    public static void main(String[] args) {
        List<Draw> draws = Helper.loadDraws(Main.class.getResource("/lotto.txt"));

        AnalysisResult results = new BasicAnalysis().analyse(draws);
        Logging.LOGGER.log(Level.INFO, results.toString());
    }

}