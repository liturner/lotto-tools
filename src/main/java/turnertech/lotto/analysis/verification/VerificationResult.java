package turnertech.lotto.analysis.verification;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.List;

import turnertech.lotto.analysis.AnalysisResult;

/**
 * Various verification results. e.g. how often a single ball was predicted etc.
 */
public class VerificationResult {
    
    private final ArrayList<AbstractMap.SimpleImmutableEntry<AnalysisResult, List<Integer>>> analysisResults;

    public VerificationResult(int plannedAnalysisCount) {
        analysisResults = new ArrayList<>(plannedAnalysisCount);
    }

    void addAnalysisResult(final AnalysisResult lastAnalysisResult, final List<Integer> hits) {
        analysisResults.add(new SimpleImmutableEntry<>(lastAnalysisResult, hits));
    }

    public int getTotalHitCount() {
        int total = 0;
        for(SimpleImmutableEntry<AnalysisResult, List<Integer>> analysisResult : analysisResults) {
            total += analysisResult.getValue().size();
        }
        return total;
    }

    public int getDrawHitCount(final int drawHits) {
        int total = 0;
        for(SimpleImmutableEntry<AnalysisResult, List<Integer>> analysisResult : analysisResults) {
            if(analysisResult.getValue().size() == drawHits) {
                ++total;
            }
        }
        return total;
    }

    /**
     * A bye product of the verification. The last analysis result is given here
     * and is quivelant to performing one analysis on the complete ball history.
     * 
     * @return The most current analysis result.
     */
    public AnalysisResult getLastAnalysisResult() {
        return analysisResults.get(analysisResults.size() - 1).getKey();
    }

    @Override
    public String toString() {
        return String.format("%n# Verification Result%n%n- Last X Runs: %d%n- Total Hits: %d%n - # 0 Hit Draws: %d%n - # 1 Hit Draws: %d%n - # 2 Hit Draws: %d%n - # 3 Hit Draws: %d%n - # 4 Hit Draws: %d%n - # 5 Hit Draws: %d%n - # 6 Hit Draws: %d", analysisResults.size(), getTotalHitCount(), getDrawHitCount(0), getDrawHitCount(1), getDrawHitCount(2), getDrawHitCount(3), getDrawHitCount(4), getDrawHitCount(5), getDrawHitCount(6));
    }

}
